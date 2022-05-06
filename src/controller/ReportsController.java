/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Appointments;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class ReportsController implements Initializable {
    @FXML
    private Label textprompt1;

    @FXML
    private Label textvalue1;

    @FXML
    private Label forThemonthOf;

    @FXML
    private Label textprompt2;

    @FXML
    private Label textvalue2;
    
    LocalDate currentDate = LocalDate.now();
    Stage stage;
    Parent scene;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void MAINPAGE(ActionEvent event) throws IOException
    {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void CallMonthReport() throws SQLException
    {
    int Empmeeting =0;
    int Custmeeting = 0;
    
    for (Appointments temp : Appointments.getAllAppointments()) 
    {
        // remove time info from specific iteration. convert to localdate
        LocalDate Month = temp.getStart().toLocalDate();
        // if month info matches current month
        if(currentDate.getMonth() == Month.getMonth())
        {
        String appointmentType = temp.getType();
        if("Business Appointment".equals(appointmentType))
        {
        Empmeeting++;
        }// end if 
        if("Residential Appointment".equals(appointmentType))
        {
        Custmeeting++;
        }// end if
        }// end month if 
        // clear values
        clearValues();
        // fill values
        forThemonthOf.setText("For the month of : "+currentDate.getMonth());
        textprompt1.setText("Current number of Residential Appointments are: ");
        textvalue1.setText(String.valueOf(Custmeeting));
        textprompt2.setText("Current number of Business Appointments are: ");
        textvalue2.setText(String.valueOf(Empmeeting));
        
    }// end for 
    }// end method
    public void callMonthreportType() throws SQLException
    {
     int count = 0;
     for(Appointments temp : Appointments.getAllAppointments()) 
     {
     // remove time info from specific iteration. convert to localdate
     LocalDate Month = temp.getStart().toLocalDate();
     // if month info matches current month
     if(currentDate.getMonth() == Month.getMonth())
     {
     count++;    
     }// end if 
     }// end for
     // clear prevouse values 
     clearValues();
     forThemonthOf.setText("For the month of : "+currentDate.getMonth());
     textprompt1.setText("Current number of Appointments are : ");
     textvalue1.setText(String.valueOf(count)); 
     }// end method
    
    public void clearValues()
    {
            forThemonthOf.setText("");
            textprompt1.setText("");
            textvalue1.setText("");
            textprompt2.setText("");
            textvalue2.setText("");
    }
}// end java class

