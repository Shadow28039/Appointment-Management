/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.User;
import model.Utility;

/**
 *
 * @author shado
 */
public class LoginController implements Initializable {
  
    @FXML
    public Label label;
    public TextField Userfield;
    public TextField Passwordfield;
    private static Connection connect = null;
    @FXML
    Stage stage;
    Parent scene;
    
    
    public void LoginButtonAction(ActionEvent event) throws SQLException, IOException
    {
    
    if(Userfield.getText().equals("")|| Passwordfield.getText().equals(""))
    {
    label.setText("Username or password has not been filled");
    }
    if(!Userfield.getText().equals("")&& !Passwordfield.getText().equals("")) 
    {
    // run data base connect
    System.out.println("Attempting to connect to database");
    Utility.verifyUser(Userfield.getText(),Passwordfield.getText());
    
    }// end if
    for(User check : User.getAllUsers())
    {
        
    // if fields match existing values call next loader // not found alert in utility
    if(Userfield.getText().equals(check.getUserName())&& Passwordfield.getText().equals(check.getPassword()))
    {   
        
        Utility.verifyCustomerList();
        Utility.verifyAppointments(check.getuserID());
        record(check.getUserName());// call record for data file logging
        String timeZone = "";
        for(User temps: User.getAllUsers())
        {
            timeZone = temps.getUserTimeZone();
        }
        System.out.println(timeZone);
        TimeZoneController.TimeZoneCodeComingIn(timeZone);
        
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/UserPage.fxml"));
        UserPart.load();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show();   
    }// end if
    else
    {
    JOptionPane.showMessageDialog(null,"The Provided Information does not match our records");
    }
        }// end for
    }// end method login
    public void record(String Username) throws IOException
    {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date(); 
    
    File newRecord = new File("UserRecord.txt");
    FileWriter Write = new FileWriter(newRecord, true);
    BufferedWriter Writer = new BufferedWriter(Write);
    PrintWriter add = new PrintWriter(Writer);
    
    File Userlog = new File("UserRecord.txt");
        // if file does not exist create file 
        if (newRecord.exists()==false)
        {
            newRecord.createNewFile();
            add.print("User: " + Username + " "+"TimeStamp: " + dateFormat.format(date)+"Local Data: "+Locale.getDefault()+"\n");
            System.out.println("No file on record, create record");
        }// end if 
        else // add values to existing file 
        {
        add.print("|User: " + Username + " |"+"TimeStamp: " + dateFormat.format(date)+" |Region: "+Locale.getDefault()+"\n");
        System.out.println("File already exists information has been added");
        }
        add.close();
        // add data to file 
    }// emd record 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
