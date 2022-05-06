/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Appointments;
import model.User;
import javaapplication9.GeneralInterface;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class TimeZoneController implements Initializable {
    Stage stage;
    Parent scene;
    @FXML
            
    void Cancel(ActionEvent event) throws IOException {
    stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
    stage.setScene(new Scene(scene));
    stage.show();
    }
    @FXML
    void CT(ActionEvent envent)
    {
    CentralTime();
    }
    public static void CentralTime() {
    int index = 0;
    int index2 = 0;
    
    for(User temp: User.getAllUsers())
    {  
    temp.setUserTimeZone("Central Standard Time");
    User.getAllUsers().set(index,temp); 
    } // end for
    for(Appointments temp2: Appointments.getAllAppointments())
    {
        // utc is 6 hours ahead of central standard time (deduct 6 hours)
    LocalDateTime olddateStart = temp2.getStart();
    LocalDateTime newdateStart = olddateStart.minusHours(6);
    temp2.setStart(newdateStart);
    LocalDateTime olddateEnd = temp2.getEnd();
    LocalDateTime newdateEnd = olddateEnd.minusHours(6);
    temp2.setEnd(newdateEnd);
    
    Appointments.getAllAppointments().set(index2,temp2);
    index2++;
    }// end second for 
    
    // lambda expression to inform user of changes successfully made to timezone information 
    GeneralInterface text = ms -> ms +" is the new timezone information";
    System.out.println(text.sendMessage("Central Standard Time"));
    
    }// end method
    
    @FXML
    void ET(ActionEvent event)
    {
    EasternTime();
    }
    public static void EasternTime() {
    int index = 0;
    int index2 = 0;
    for(User temp: User.getAllUsers())
    {  
    temp.setUserTimeZone("Eastern Standard Time");
    User.getAllUsers().set(index,temp);        
    } // end for 
    for(Appointments temp2: Appointments.getAllAppointments())
    {
    LocalDateTime olddateStart = temp2.getStart();
    LocalDateTime newdateStart = olddateStart.minusHours(5);
    temp2.setStart(newdateStart);
    LocalDateTime olddateEnd = temp2.getEnd();
    LocalDateTime newdateEnd = olddateEnd.minusHours(5);
    temp2.setEnd(newdateEnd);
    // utc is 6 hours ahead of central standard time (deduct 6 hours)
    Appointments.getAllAppointments().set(index2,temp2);
    index2++;
    }// end second for 
    // lambda expression to inform user of changes successfully made to timezone information 
    GeneralInterface text = ms -> ms +" is the new timezone information";
    System.out.println(text.sendMessage("Eastern Standard Time"));
    }// end method

    @FXML
    void MT(ActionEvent event)
    {
    MountainTime();
    }
    public static void MountainTime() {
    int index = 0;
    int index2 = 0;
    for(User temp: User.getAllUsers())
    {  
    temp.setUserTimeZone("Mountain Standard Time");
    User.getAllUsers().set(index,temp);        
    } // end for 
    for(Appointments temp2: Appointments.getAllAppointments())
    {
    LocalDateTime olddateStart = temp2.getStart();
    LocalDateTime newdateStart = olddateStart.minusHours(7);
    temp2.setStart(newdateStart);
    
    LocalDateTime olddateEnd = temp2.getEnd();
    LocalDateTime newdateEnd = olddateEnd.minusHours(7);
    temp2.setEnd(newdateEnd);
    
    Appointments.getAllAppointments().set(index2,temp2);
    index2++;
    }// end second for 
    GeneralInterface text = ms -> ms +" is the new timezone information";
    System.out.println(text.sendMessage("Mountain Standard Time"));
    }// end method

    @FXML
    void PT(ActionEvent event)
    {
    PacificTime();
    }
    public static void PacificTime() {
    int index = 0;
    int index2 = 0; 
    for(User temp: User.getAllUsers())
    {  
    temp.setUserTimeZone("Pacific Standard Time");
    User.getAllUsers().set(index,temp);        
    } // end for 
    for(Appointments temp2: Appointments.getAllAppointments())
    {
    LocalDateTime olddateStart = temp2.getStart();
    LocalDateTime newdateStart = olddateStart.minusHours(8);
    temp2.setStart(newdateStart);
    LocalDateTime olddateEnd = temp2.getEnd();
    LocalDateTime newdateEnd = olddateEnd.minusHours(8);
    temp2.setEnd(newdateEnd);
    Appointments.getAllAppointments().set(index2,temp2);
    index2++;
    }// end second for 
    GeneralInterface text = ms -> ms +" is the new timezone information";
    System.out.println(text.sendMessage("Pacific Standard Time"));
    }// end method
    /**
     * Initializes the controller class.
     */  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    // lambda expression for converting times to UTC timezone for database storage
    
    public LocalDateTime TimeZoneCode(LocalDateTime temp){
        
        LocalDateTime newValue = temp;
        String TimeZone = "";
        for(User check : User.getAllUsers())
        {
         TimeZone = check.getUserTimeZone();
        }
        if(TimeZone.equals("Pacific Standard Time"))
        {
            newValue = temp.plusHours(8);
        }// end if 
        if(TimeZone.equals("Central Standard Time"))
        {
            newValue = temp.plusHours(6);
        }
        if(TimeZone.equals("Eastern Standard Time"))
        {
            newValue = temp.plusHours(5);
        }
        if(TimeZone.equals("Mountain Standard Time"))
        {
            newValue = temp.plusHours(7);
        }
    return newValue;
    }
    
    // program start convert to time zone 
   
    public static void TimeZoneCodeComingIn(String zone)
    {   
        System.out.println(zone);
        
        if(zone.equals("Pacific Standard Time"))
        {
            PacificTime();
        }
        if(zone.equals("Central Standard Time"))
        {
            CentralTime();
        }
        if(zone.equals("Eastern Standard Time"))
        {
            EasternTime();
        }
        if(zone.equals("Mountain Standard Time"))
        {
            MountainTime();
        }
        System.out.println("TimeZone Auto changed");
    }// end method
    
}// end class
