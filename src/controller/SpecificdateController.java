package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Appointments;
import model.Utility;

public class SpecificdateController {

    @FXML
    private Label LABEL8;
    
    @FXML
    private Label LABEL83;
    
    @FXML
    private Label LABEL9;
   
    @FXML
    private Label LABEL93;
    
    @FXML
    private Label LABEL10;
    
    @FXML
    private Label LABEL103;
    
    @FXML
    public Label LABEL1;
    
    @FXML
    private Label LABEL13;
    
    @FXML
    private Label LABEL2;
  
    @FXML
    private Label LABEL23;
   
    @FXML
    private Label LABEL3;
    
    @FXML
    private Label LABEL33;
    
    @FXML
    private Label LABEL4;
    
    @FXML
    private Label LABEL43;
  
    @FXML
    private Label LABEL5;
  
    @FXML
    private Label LABEL53;
   

    Stage stage;
    Parent scene;
    LocalDate day;
    LocalDate tester;
    public void initialize() {
        // weekly controls 
        
        
        
    }
    @FXML
    void CallMain(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void getRowgetColumn(MouseEvent event) {
        // get row column info to pass into next method 
        String source1 = event.getSource().toString();
        //String source1 = event.getPickResult().toString(); //yields complete string
        System.out.println(source1);
        source1 = source1.substring(42);
        System.out.println(String.valueOf(source1));
        getAppointmentInfo(source1);
    }

    @FXML
    void getAppointmentInfo(String pass) {
        // remove all special characters and convert to int
        int id = Integer.parseInt(pass.replaceAll("[^a-zA-Z0-9]", ""));
        System.out.println(id);
        for (Appointments temp : Appointments.getAllAppointments()) {   // if values match create alert message with app info 
            if (temp.getAppointmentID() == id) {
                String date = String.valueOf(temp.getStart());
                date = date.substring(0, 10);
                String startTime = String.valueOf(temp.getStart());
                startTime = startTime.substring(11);
                String endTime = String.valueOf(temp.getEnd());
                endTime = endTime.substring(11);
                String CustomerName = Utility.CustomerNameCall(String.valueOf(temp.getCustomerID()));
                // output message with app details 
                JOptionPane.showMessageDialog(null,
                        "Meeting Title: " + temp.getTitle() + "\n"
                        + "Meeting Date: " + date + "\n"
                        + // date
                        "Meeting Start Time: " + startTime + "\n"
                        + // times    
                        "Meeting End Time: " + endTime + "\n"
                        + "Customer Name: " + CustomerName + "\n"
                        +// convert name
                        "Location: " + temp.getLocation() + "\n"
                        + "Type: " + temp.getType() + "\n"
                        + "Info: " + temp.getContact(temp.getCustomerID()) + "\n"
                        + "Description: " + temp.getDescription()
                );
            }// end if 
        }// end for loop 
    }// end method

    public void calltime(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        System.out.println(day+"calltime");
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            System.out.println(check);
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                System.out.println(time);
                phone = temp.getContact(temp.getCustomerID());
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL8.setText("Apt ID : " + idcheck);
                        
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL83.setText("Apt ID : " + idcheck);
                        
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL9.setText("Apt ID : " + idcheck);
                      
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL93.setText("Apt ID : " + idcheck);
                        
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL10.setText("Apt ID : " + idcheck);
                      
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL103.setText("Apt ID : " + idcheck);
                        
                        break;
                    
                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        System.out.println(idcheck);
                        // set the LABEL values 
                        LABEL1.setText("APT ID: "+idcheck);
                        
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL13.setText("Apt ID : " + idcheck);
                       
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL2.setText("Apt ID : " + idcheck);
                       
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL23.setText("Apt ID : " + idcheck);
                        
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL3.setText("Apt ID : " + idcheck);
                      
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL33.setText("Apt ID : " + idcheck);
                       
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL4.setText("Apt ID : " + idcheck);
                      
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL43.setText("Apt ID : " + idcheck);
                       
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL5.setText("Apt ID : " + idcheck);
                    
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the LABEL values 
                        LABEL53.setText("Apt ID : " + idcheck);
                      
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time
public void setdate(LocalDate days)
{
    System.out.println(days+"setdate");
    //day = days;
    calltime(days);
}
}// end main
