package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Appointments;
import model.User;
import model.Utility;

public class UserPageController {
    Stage stage;
    Parent scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Employee_ID;

    @FXML
    private Label Name_ID;

    @FXML
    private Label Hire_Date;
    
    @FXML
    private Label Timestamp;

    @FXML
    public Label timezone;

    @FXML
    private TableView<Appointments> AppointmentUserTableView;
 
    @FXML
    private TableColumn<Appointments,String> TimeColumn;

    @FXML
    private TableColumn<Appointments,Integer> CustomerIDColumn;

    @FXML
    private TableColumn<Appointments,String> TypeColumn;

    @FXML
    private Label Label_ID;

    @FXML
    private Label Label_Name;

    @FXML
    private Label Label_create;

    @FXML
    private Label Label_app_type;

    @FXML
    private Label Label_timeStart;

    @FXML
    private Label Label_timeEnd;
    int UserID;
    DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm");
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    LocalDateTime pass; 
    LocalTime passtime;
    LocalTime range;
    Boolean APTFOUND = false;
    
    @FXML
    void KillActionButton(ActionEvent event) {
    // disconnect from database.
    // close application 
    System.exit(0);
    }
    @FXML
    void TimeZonePage(ActionEvent event) throws IOException {
        
        AppointmentUserTableView.getItems().clear();
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/TimeZone.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show(); 
    }
    @FXML
    void CustomersButton(ActionEvent event) throws IOException {
        
        AppointmentUserTableView.getItems().clear();
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/CustomersPage.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show(); 
    }
    @FXML
    void AppointmentPageCall(ActionEvent event) throws IOException {
        
        AppointmentUserTableView.getItems().clear();
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/AppointList.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show(); 
    }
    @FXML
    void CalenderPage(ActionEvent event) throws IOException {
        
        AppointmentUserTableView.getItems().clear();
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/CALENDER.fxml"));
        UserPart.load();
       
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show(); 
        
        
    }
    @FXML
    void ReportPage(ActionEvent event) throws IOException {
        
        AppointmentUserTableView.getItems().clear();
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/Reports.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show(); 
    }
     @FXML
    void populateLabels(ActionEvent event) {

    Appointments temp = AppointmentUserTableView.getSelectionModel().getSelectedItem();
    String id = String.valueOf(temp.getCustomerID());
    String createDate = String.valueOf(temp.getCreateDate());
    createDate = createDate.substring(0,10);
    String type = temp.getType();
    String start = String.valueOf(temp.getStart());
    start = start.substring(11,16);
    String end = String.valueOf(temp.getEnd());
    end = end.substring(11,16);
    String name = Utility.CustomerNameCall(String.valueOf(temp.getCustomerID()));
    
    Label_ID.setText(id);
    Label_Name.setText(name);
    Label_create.setText(createDate);
    Label_app_type.setText(type);
    Label_timeStart.setText(start);
    Label_timeEnd.setText(end);  
    }
   
    @FXML
    void initialize(){
        
        
        Timestamp.setText(String.valueOf(currentDate));
        // lambda expression used to reduce code length for label population (easier system read as well )
        User.getAllUsers().stream().map((check) -> {
            Employee_ID.setText(String.valueOf(check.getuserID()));
            return check;
        }).map((check) -> {
            Name_ID.setText(check.getUserName());
            return check;
        }).forEachOrdered((check) -> {
            Hire_Date.setText(String.valueOf(check.getcreateDate()));
        }); // end
        //second lambda
        User.getAllUsers().forEach((Temp) -> {
            timezone.setText(Temp.getUserTimeZone());
        });//end 
        UserID = Integer.parseInt(Employee_ID.getText());
        // auto set values for appointments based on timezone
        
        //assign values to table
        // pass todays appointments into seprate table for population
        
        for(Appointments temp : Appointments.getAllAppointments())
        {
        String passed = String.valueOf(temp.getStart());
        String Date = String.valueOf(passed.substring(0,10));
        String currentDatepass = String.valueOf(currentDate);
        if(Date.equals(currentDatepass))
        {
         Appointments.AddTodayAppointment(temp);
        }// end if
        }// end for 
        
        AppointmentUserTableView.setItems(Appointments.getAllToday());
        
        TimeColumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
        CustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        // show alert for meetings within 15 
        for(Appointments temp2 : Appointments.getAllToday())
        {
            // apt time
            LocalDateTime temp = temp2.getStart();
            LocalTime aptTime = temp.toLocalTime();
            
            String aptTimehour = String.valueOf(aptTime);
                   aptTimehour = aptTimehour.substring(0,2);
            String aptTimemin = String.valueOf(aptTime);
                   aptTimemin = aptTimemin.substring(3,5);
            
            int aptmin = Integer.parseInt(aptTimehour+aptTimemin);
            
            // current time
            String current = (String.valueOf(LocalTime.now().format(time)));
            String currentHour = current.substring(0,2);
            String currentMin = current.substring(3,5);
            int curt = Integer.parseInt(currentHour+currentMin);
            
            // current time plus 15
            LocalTime current15 = LocalTime.now().plusMinutes(15);
            String current15String = String.valueOf(current15);
            String current15Hour = current15String.substring(0,2);
            String current15Min = current15String.substring(3,5);
            int curt15 = Integer.parseInt(current15Hour+current15Min);
           
            
            //apt time plus 30
            LocalTime TimeRange = aptTime.plusMinutes(30);
            String TimeRangeString = String.valueOf(TimeRange);
            String TimeRangeHour = TimeRangeString.substring(0,2);
            String TimeRangeMin = TimeRangeString.substring(3,5);
            int rangeMin = Integer.parseInt(TimeRangeHour+TimeRangeMin);
           
        // current time <= apt time <= current time+15
        if( curt <= aptmin && aptmin <= curt15)
        {
            JOptionPane.showMessageDialog(null,"This User has a appointment due within the next 15 minutes");
        }// inner if 
        // appointment <= current time <= appointment+30
        if(aptmin <= curt && curt <= rangeMin)
        {
            JOptionPane.showMessageDialog(null,"This User has a appointment currently due");
        }
        }// end for
        }// end initialize
        

}// end class
