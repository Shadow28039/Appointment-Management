/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class AppointListController implements Initializable {
    Stage stage;
    Parent scene;
    @FXML
    String Contact;
    public TableView<Appointments> AppointmentTableView;

    @FXML
    private TableColumn<Appointments,Integer> AppointmentIdColumn;

    @FXML
    private TableColumn<Appointments,Integer> CustomerIDColumn;

    @FXML
    private TableColumn<Appointments,String> TitleColumn;

    @FXML
    private TableColumn<Appointments,String> LocationColumn;
    @FXML
    private TableColumn<Appointments,LocalDateTime> StartTimeColumn;

    @FXML
    private TableColumn<Appointments,LocalDateTime> EndTimeColumn;

    @FXML
    private TableColumn<Appointments,String> UrlListColumn;

    @FXML
    void ReturnMain(ActionEvent event) throws IOException {
  
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
       @FXML
    void AddAppointment(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/NewAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void DeleteAppointment(ActionEvent event) throws SQLException {
    Appointments temp = AppointmentTableView.getSelectionModel().getSelectedItem();
    
    if(Appointments.DeleteAppointment(temp))// pass id into remove delete appointment
    {   // remove appointment row from table view 
        Appointments.getAllAppointments().remove(AppointmentTableView.getSelectionModel().getSelectedItem());
        
    } // end if statement
    }
    
    @FXML
    void UpdateAppointment(ActionEvent event) throws IOException {
         // call modify Customer view 
        FXMLLoader loaderPart = new FXMLLoader();
        loaderPart.setLocation(getClass().getResource("/view/EditAppointment.fxml"));
        loaderPart.load();
        // send selected row into modify part controller view
       EditAppointmentController ModAppControl = loaderPart.getController();
       ModAppControl.sendAppointments(AppointmentTableView.getSelectionModel().getSelectedItem());
       // reset table before calling to avoid repeat data 
       stage = (Stage)((Button)event.getSource()).getScene().getWindow();
       Parent runner = loaderPart.getRoot();
       stage.setScene(new Scene(runner));
       stage.show();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
    //assign values to table 
    AppointmentTableView.setItems(Appointments.getAllAppointments());
    AppointmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
    CustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
    TitleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
    LocationColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
    StartTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
    EndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("End"));
    UrlListColumn.setCellValueFactory(new PropertyValueFactory<>("Url"));
    }    
    
}
