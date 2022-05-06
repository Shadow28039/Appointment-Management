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
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Customers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.User;
import model.Utility;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class EditCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Stage stage;
    Parent scene;
    @FXML
    public Label CustomerIDField;
    @FXML
    public TextField CustomerNameField;
    @FXML
    public TextField CustomerAddressField;
    @FXML
    public TextField ZipcodeField;
    @FXML
    public TextField PhoneNumberField;
    @FXML
    public TextField CustomerAddress2Field;
    @FXML
    public TextField CityField;
    @FXML
    public ToggleGroup ActiveGroup;
    @FXML
    public RadioButton RadioButtonActive;
    @FXML
    public RadioButton RadioButtonNonActive;
    int active;
    int IDcheck;
    String creator;
    Timestamp createDate;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Timestamp update = Timestamp.valueOf(dateFormat.format(date));

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void ActiveCustomer(ActionEvent event) {
        active = 1;
    }

    @FXML
    void ExitPage(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    void NonActiveCustomer(ActionEvent event) {
        active = 0;
    }

    @FXML
    void OnActionSave(ActionEvent event) throws SQLException, IOException {
        // declare values from existing values in boxes 
        int Customerid = Integer.parseInt(CustomerIDField.getText());
        String name = CustomerNameField.getText();
        String Address = CustomerAddressField.getText();
        String Address2 = CustomerAddress2Field.getText();
        String Zipcode = ZipcodeField.getText();
        String PhoneNumber = PhoneNumberField.getText();
        String City = CityField.getText();
        String UserName = "";
        // assign username value 
        for (User check : User.getAllUsers()) {
            UserName = check.getUserName();
        }
        String ZipcodeCheck = "^[0-9]{5}$"; // 5 digit zip code 
        String PhoneCheck = "^(1\\\\-)?[0-9]{3}\\\\-?[0-9]{3}\\\\-?[0-9]{4}$";
        // check to make sure values have been entered for every text field
        if ((!CustomerIDField.getText().equals("") && !CustomerNameField.getText().equals("")
                && !CustomerAddressField.getText().equals("") && !ZipcodeField.getText().equals("") && !PhoneNumberField.getText().equals(""))
                && !CityField.getText().equals("")) {
            String zip = ZipcodeField.getText();
            String phone = PhoneNumberField.getText();
            //phone and zipcode check for formatting
            if (zipCheck(zip)&& phoneCheck(phone)) {
                // update information from each table based on user input and remove old values
                Utility.UpdateCustomerToDatabase(Customerid,name,Address,Address2,Zipcode,City,phone,active,createDate,
            creator,update,UserName);

                FXMLLoader UserPart = new FXMLLoader();
                UserPart.setLocation(getClass().getResource("/view/UserPage.fxml"));
                UserPart.load();
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                Parent second = UserPart.getRoot();
                stage.setScene(new Scene(second));
                stage.show();
            } // end inner if for zipcode and phone 
            else {
                JOptionPane.showMessageDialog(null, "Please ensure that the customers zipcode and phone number has been properly entered: ");

            }// end else
        }// end outer if 
           else
   {
       JOptionPane.showMessageDialog(null,"Please ensure that all data has been properly entered: ");
   }// end outer-if else statement 
    }// end save 

    @FXML
    void Cancel(ActionEvent event) throws IOException {
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/CustomersPage.fxml"));
        UserPart.load();
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show();
    }

    void sendCustomer(Customers added) {
        CustomerNameField.setText(String.valueOf(added.getCustomerName()));
        CustomerIDField.setText(String.valueOf(added.getCustomerId()));
        CustomerAddressField.setText(added.getAddress());
        CustomerAddress2Field.setText(added.getAddress2());
        ZipcodeField.setText(added.getZipCode());
        PhoneNumberField.setText(added.getphone());
        CityField.setText(added.getcity());
        active = added.getActive();
        creator = added.getCreatedBy();
        createDate = added.getDate();
        if (active == 1) {
            RadioButtonActive.setSelected(true);
        }
        if (active == 0) {
            RadioButtonNonActive.setSelected(true);
        }
    }//send customer  
     @FXML
    public static boolean phoneCheck(String temp)
    {
    Pattern phone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        //phone check supports 999-999-9999 
    Matcher checker = phone.matcher(temp);
    return (checker.find()&& checker.group().equals(temp));
    }// end phone check 
    @FXML
    public static boolean zipCheck(String temp)
    {
    Pattern zip = Pattern.compile("\\d{5}"); 
    Matcher checker = zip.matcher(temp);
    return (checker.find()&& checker.group().equals(temp));
    }// end phone check 
} // end main 
