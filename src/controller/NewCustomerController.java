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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Customers;
import model.User;
import model.Utility;
/**
 * FXML Controller class
 *
 * @author shado
 */

public class NewCustomerController implements Initializable {
    Stage stage;
    Parent scene;
    int active = 1;
    String CustomerNameValue = "";
    int CustomerId;
    String CustomerName;
    String Address;
    String Address2;
    String Zipcode;
    String Phone;
    
    String createdBy;
    Timestamp Update;
    String lastUpdateBy;
    String city;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Timestamp update = Timestamp.valueOf(dateFormat.format(date));
    Timestamp createDate = Timestamp.valueOf(dateFormat.format(date));
    @FXML
    public TextField CustomerNameField;
    public TextField CustomerAddressField;
    public TextField CustomerAddress2Field;
    public TextField ZipcodeField;
    public TextField PhoneNumberField;
    public TextField CityField;
    
    
    @FXML
    private RadioButton RadioButtonActive;
    @FXML
    private RadioButton RadioButtonNonActive;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void ActiveCustomer(ActionEvent event) {
        active = 1;
        System.out.println("1");
    }
    @FXML
    void NonActiveCustomer(ActionEvent event) {
        active = 0;
        System.out.println("0");
    }
    @FXML
    void HomePage(ActionEvent event) throws IOException {
        // recall page without saving info
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @FXML
    void OnActionSave(ActionEvent event) throws SQLException, IOException 
    {
     
    // run if fields are filled 
    if(!CustomerNameField.getText().equals("")&&!CustomerAddressField.getText().equals("")&&
            !ZipcodeField.getText().equals("")&&!PhoneNumberField.getText().equals("")&& !CityField.getText().equals(""))
    {
        String zip = ZipcodeField.getText();
        String phone = PhoneNumberField.getText();
        //phone and zipcode check for formatting
    if(zipCheck(zip)&& phoneCheck(phone))
    {
    // assign name field to name variable
    CustomerName = CustomerNameField.getText();
    Address = CustomerAddressField.getText();
    Address2 = CustomerAddress2Field.getText();
    Zipcode = ZipcodeField.getText();
    Phone = PhoneNumberField.getText();
    city = CityField.getText();
    // assign values to to id references using a calculated value based of object class sizes, done correctly should allow for accurate foreign key references
    
        //lambra expression used for a reduction in code bloat and improved readability, can also be used to reduce the jar file size 
    User.getAllUsers().forEach((check) -> {
    // assign username to createBy variable
    createdBy = check.getUserName();
    }); // end for 
    Utility.addCustomerToDatabase(Customers.getNextId(),CustomerName,Address,Address2,Zipcode,city,Phone,active,createDate,createdBy,Update,createdBy);
   
    stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
    stage.setScene(new Scene(scene));
    stage.show();
    }// end phone and zipcode check
    // else for zipcode check
    else
    {
     JOptionPane.showMessageDialog(null,"Please ensure that the customers zipcode and phone number has been properly entered: ");
    }
   } // end inner if
   else
   {
       JOptionPane.showMessageDialog(null,"Please ensure that all data has been properly entered: ");
   }
    }// end action save
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
    
   
}