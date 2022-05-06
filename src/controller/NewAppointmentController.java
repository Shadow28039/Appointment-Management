/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Appointments;
import model.User;
import model.Utility;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class NewAppointmentController implements Initializable {
    
    ObservableList<String> TimeBox = FXCollections.observableArrayList("08:00AM-08:30AM",
           "08:30AM-09:00AM","09:00AM-09:30AM","09:30AM-10:00AM","10:00AM-10:30AM",
           "10:30AM-11:00AM","01:00PM-01:30PM",
           "01:30PM-02:00PM","02:00PM-02:30PM","02:30PM-03:00PM","03:00PM-03:30PM",
           "03:30PM-04:00PM","04:00PM-04:30PM","04:30PM-05:00PM");
    
    Stage stage;
    Parent scene;
    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField TitleField;
    @FXML
    public TextField DateField;
    @FXML
    public TextField CustomerNameField;
    @FXML
    public TextField LocationField;
    @FXML
    public TextField DescriptionField;
    @FXML
    public TextField ContactInfoTextField;
    @FXML
    public TextField CustomerIDField;
    @FXML
    public RadioButton CustomerMeeting;
    @FXML
    public ToggleGroup MeetingType;
    @FXML
    public RadioButton EmployeeMeeting;
    @FXML
    public ComboBox StartComboBox;

    
    String Description;
    String MeetingTypeText;
    String Date;
    String Title;
    String contact;
    String Location;
    int UserID;
    String CreatedBy;
    LocalDateTime CreateDate = LocalDateTime.now();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Timestamp update = Timestamp.valueOf(dateFormat.format(date));
    int flag = 0;
    
        
    @FXML
    void MeetingTypeCustomerSet(ActionEvent event) {
    MeetingTypeText = "Residential Appointment";
    }
    @FXML
    void MeetingTypeEmployeeSet(ActionEvent event) {
    MeetingTypeText = "Business Appointment";
    }
    @FXML
    void ExitPage(ActionEvent event) throws IOException {
    stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
    stage.setScene(new Scene(scene));
    stage.show();
    }
    @FXML
    public static boolean phoneCheck(String temp)
    {
    Pattern phone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        //phone check supports 999-999-9999 
    Matcher checker = phone.matcher(temp);
    return (checker.find()&& checker.group().equals(temp));
    }// end phone check 
    
    @FXML
    void OnActionSave(ActionEvent event) throws SQLException, IOException {
         
    // run if fields are filled 
    if(!CustomerNameField.getText().equals("")&&!LocationField.getText().equals("")
    && !DescriptionField.getText().equals("")&&!DateField.getText().equals("")&&
       !TitleField.getText().equals("")&&!ContactInfoTextField.getText().equals("")
    &&!DateField.getText().equals("")&&!CustomerIDField.getText().equals(""))
    {   
        String phone = ContactInfoTextField.getText();
        //System.out.println(phone);
        //phone and zipcode check for formatting
    if(phoneCheck(phone))
    {
        Date = DateField.getText();
        String Time = (String)StartComboBox.getValue();
        String start = Time.substring(0, 7);
        String end = Time.substring(8, 15);

        String tempTimestart = Utility.setTimeConvertion(start);
        String tempTimeend = Utility.setTimeConvertion(end);
        // combine for date time value
        // use substring of stat time to remove am and pm from string and add to date
        String startdateTimeString = Date + "T" + tempTimestart + ":00";
        String enddateTimeString = Date + "T" + tempTimeend + ":00";
        
        //string to date
        LocalDateTime StartValue = LocalDateTime.parse(startdateTimeString);
        LocalDateTime EndValue = LocalDateTime.parse(enddateTimeString);
        
        //System.out.println(String.valueOf(StartValue));
        //System.out.println(String.valueOf(EndValue));
        
        // assign location field to location variable 
        Location = LocationField.getText();
        
        Description = DescriptionField.getText();
        
        Title = TitleField.getText();
        
        contact = ContactInfoTextField.getText();
        
        int CustomerID = Integer.parseInt(CustomerIDField.getText());
            // assign userid value
        //System.out.println("before for loop");
        for(User temp : User.getAllUsers())
        {
         UserID = temp.getuserID();
        }
        String url = "";
        // as long as customer id is not 0 run add 
        if(CustomerID == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Customer Not Found");
            alert.setContentText("the specified customer was not found, please ensure data was entered correctly."+"\n"+
                    "Possible causes include spacing and capitilization issues. EXP. Mike Rogger ");
            alert.showAndWait();
        }// end inner if for customer id not found  
        else
        {
         flag = Utility.checkDateInfo(StartValue);
        
        if(flag == 0)
        {
        Utility.addAppointment(Appointments.getNextId(),CustomerID,UserID,Title,Description,Location,contact,MeetingTypeText,
        url,StartValue,EndValue,CreatedBy,update,CreatedBy);
        // call appointment page
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/AppointList.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show();
        }// flag 
        else
        {
        JOptionPane.showMessageDialog(null, " the appointment time is currently filled ");
        }
        }// end else 
        }//if phone matches 
        else
        {
        JOptionPane.showMessageDialog(null,"Please ensure that the customers phone number has been properly entered: ");
        }// else for phone check
        }// end outer if 
        else
        {
        JOptionPane.showMessageDialog(null,"Please ensure that all data has been properly entered: ");
        }
        }// end save method 

    @FXML
    void ReopenPage(ActionEvent event) throws IOException {
    stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    scene = FXMLLoader.load(getClass().getResource("/view/NewAppointmentController.fxml"));
    stage.setScene(new Scene(scene));
    stage.show();
    }
    @FXML
    void VerifyCustomerID(ActionEvent event) {
        CustomerIDField.setText(String.valueOf
        (Utility.CustomerIDCall(CustomerNameField.getText())));
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StartComboBox.setValue("08:00AM-08:30AM");
        StartComboBox.setItems(TimeBox);
        // TODO
        // get userid and createby by running through userlog (should only contain 1 reference )
        for(User check : User.getAllUsers())
        {
            UserID = check.getuserID();
            CreatedBy = check.getUserName();
        }// end for statement 
    } // end initialize    
}// end main 
