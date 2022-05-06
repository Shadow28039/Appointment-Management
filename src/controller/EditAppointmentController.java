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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditAppointmentController implements Initializable {

    Stage stage;
    Parent scene;
    // 11 to 12 blacked out for department lunch break 
    ObservableList<String> TimeBox = FXCollections.observableArrayList("08:00AM-08:30AM",
            "08:30AM-09:00AM", "09:00AM-09:30AM", "09:30AM-10:00AM", "10:00AM-10:30AM",
            "10:30AM-11:00AM", "01:00PM-01:30PM",
            "01:30PM-02:00PM", "02:00PM-02:30PM", "02:30PM-03:00PM", "03:00PM-03:30PM",
            "03:30PM-04:00PM", "04:00PM-04:30PM", "04:30PM-05:00PM", "05:00PM-05:30PM");

    @FXML
    private TextField TitleField;

    @FXML
    private TextField CustomerNameField;

    @FXML
    private TextField CustomerIDField;

    @FXML
    private TextField LocationField;

    @FXML
    private TextField ContactInfoTextField;

    @FXML
    private TextField DateField;

    @FXML
    private TextField DescriptionField;

    @FXML
    private RadioButton CustomerMeeting;

    @FXML
    private RadioButton EmployeeMeeting;

    @FXML
    private ToggleGroup MeetingType;
    @FXML
    private ComboBox StartComboBox;

    String meetingType;
    int AppointmentID;
    LocalDateTime createDate;
    String createdBy;
    int UserID;
    int CustomerID;
    String checker;
    int flag = 0;

    @FXML
    void MeetingTypeCustomerSet(ActionEvent event) {
        meetingType = "Residential Appointment";
    }

    @FXML
    void MeetingTypeEmployeeSet(ActionEvent event) {
        meetingType = "Business Appointment";
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void sendAppointments(Appointments added) {
        CustomerID = added.getCustomerID();
        //System.out.println(id);
        String idstring = String.valueOf(CustomerID);
        //System.out.println(idstring);
        String name = Utility.CustomerNameCall(idstring);
        //System.out.println(name);
        String type = added.getType();
        //System.out.println(type);
        createdBy = added.getcreatedBy();
        createDate = added.getCreateDate();
        UserID = added.getUserID();

        // set textfields
        TitleField.setText(String.valueOf(added.getTitle()));
        CustomerNameField.setText(name);
        CustomerIDField.setText(String.valueOf(CustomerID));
        LocationField.setText(String.valueOf(added.getLocation()));
        ContactInfoTextField.setText(String.valueOf(added.getContact(added.getCustomerID())));
        DescriptionField.setText(String.valueOf(added.getDescription()));
        AppointmentID = added.getAppointmentID();
        // get only date info from start
        checker = String.valueOf(added.getStart());
        String Date = String.valueOf(added.getStart());
        String start = String.valueOf(added.getStart());
        // substring start for just time (11:00)
        start = start.substring(11, 16);

        String end = String.valueOf(added.getEnd());
        // substring end for just time (12:00)
        end = end.substring(11, 16);
        // combine values for combo box
        String newEnd = Utility.getTimeConvertion(end);
        String newStart = Utility.getTimeConvertion(start);
        String combined = newStart + "-" + newEnd;
        // set text fields
        DateField.setText(Date.substring(0, 10));

        StartComboBox.setValue(combined);

        StartComboBox.setItems(TimeBox);
        // logic check for type radio buttons 
        if ("Residential Appointment".equals(type)) {
            meetingType = "Residential Appointment";
            CustomerMeeting.setSelected(true);
        }
        if ("Business Appointment".equals(type)) {
            meetingType = "Business Appointment";
            EmployeeMeeting.setSelected(true);
        }
    }//send customer 

    @FXML
    void OnActionSave(ActionEvent event) throws IOException, SQLException {

        // run if fields are filled 
        if (!CustomerNameField.getText().equals("") && !LocationField.getText().equals("")
                && !DescriptionField.getText().equals("") && !DateField.getText().equals("")
                && !TitleField.getText().equals("") && !ContactInfoTextField.getText().equals("")
                && !DateField.getText().equals("")) {
            String phone = ContactInfoTextField.getText();
            //phone and zipcode check for formatting
            if (phoneCheck(phone)) {
                String Date = DateField.getText();
                String Time = StartComboBox.getValue().toString();

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
                System.out.println(String.valueOf(StartValue));
                System.out.println(String.valueOf(EndValue));
                // assign location field to location variable
                String Location = LocationField.getText();
                String Description = DescriptionField.getText();
                String Title = TitleField.getText();
                String contact = ContactInfoTextField.getText();

                // url value null for tiume being
                String url = "";
                // get current user id and name 
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                String username = "";
                for (User temp : User.getAllUsers()) {
                    UserID = temp.getuserID();
                    username = temp.getUserName();
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                Timestamp update = Timestamp.valueOf(dateFormat.format(date));
                // if statement for checking flag only if time has been changed 
                if(checker.equals(startdateTimeString)){
                flag = Utility.checkDateInfo(StartValue);
                }
                if (flag == 0) {
                    Utility.UpdateAppointment(AppointmentID, CustomerID, UserID, Title, Description, Location, contact, meetingType,
                            url, StartValue, EndValue, createDate, createdBy, update, username);
                    // call appointment page
                    FXMLLoader Appointmentcall = new FXMLLoader();
                    Appointmentcall.setLocation(getClass().getResource("/view/AppointList.fxml"));
                    Appointmentcall.load();
                    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    Parent caller = Appointmentcall.getRoot();
                    stage.setScene(new Scene(caller));
                    stage.show();
                }// flag check
                else {
                    JOptionPane.showMessageDialog(null, "the appointment time is currently filled : ");
                }
            }// end if for phone check
            else {
                JOptionPane.showMessageDialog(null, "Please ensure that the customers zipcode and phone number has been properly entered: ");
            }
        }// end if 
        else {
            JOptionPane.showMessageDialog(null, "Please ensure that all data has been properly entered: ");
        }// end else statement for value check  
    } // end save

    @FXML
    public static boolean phoneCheck(String temp) {
        Pattern phone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        //phone check supports 999-999-9999 
        Matcher checker = phone.matcher(temp);
        return (checker.find() && checker.group().equals(temp));
    }// end phone check 

    @FXML
    void ExitPage(ActionEvent event) {
        FXMLLoader Appointmentcall = new FXMLLoader();
        Appointmentcall.setLocation(getClass().getResource("/view/UserPage.fxml"));
        try {
            Appointmentcall.load();
        } catch (IOException ex) {
            Logger.getLogger(EditAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent caller = Appointmentcall.getRoot();
        stage.setScene(new Scene(caller));
        stage.show();
    }

}
