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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customers;
import model.Utility;

/**
 * FXML Controller class
 *
 * @author shado
 */
public class CustomersPageController implements Initializable {
    Stage stage;
    Parent scene;
    @FXML
    public TableView<Customers> CustomerTableView;

    @FXML
    public TableColumn<Customers,Integer> CustomerIdColumn;

    @FXML
    public TableColumn<Customers,String> CustomerNameColumn;

    @FXML
    public TableColumn<Customers,String> AddressColumn;

    @FXML
    public TableColumn<Customers,Integer> activeColumn;

    @FXML
    public TableColumn<Customers,Timestamp> CreatedDateColumn;

    @FXML
    public TableColumn<Customers,String> CreatedByColumn;

    @FXML
    public TableColumn<Customers,Timestamp> lastUpdateColumn;

    @FXML
    public TableColumn<Customers,String> lastUpdateByColumn;
    
    @FXML
    public TextField SearchField; 

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //assign values to table 
    CustomerTableView.getItems().clear();
    CustomerTableView.setItems(Customers.getAllCustomers());
    CustomerIdColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
    CustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
    AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
    activeColumn.setCellValueFactory(new PropertyValueFactory<>("Active"));
    CreatedDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
    CreatedByColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedBy"));
    lastUpdateColumn.setCellValueFactory(new PropertyValueFactory<>("Update"));
    lastUpdateByColumn.setCellValueFactory(new PropertyValueFactory<>("UpdateBy"));
    }    
     @FXML
    void AddCustomer(ActionEvent event) throws IOException {
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/NewCustomer.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void DeleteCustomer(ActionEvent event) throws SQLException {
    Customers temp = CustomerTableView.getSelectionModel().getSelectedItem();
    
  
    if(Customers.DeleteCustomer(temp))// pass id into remove product 
    {   
        // delete all assoc appt
        Utility.DeleteAssociatedAppointment(temp.getCustomerId());
        // country delete section 
    } // end if statement
    }

    @FXML
    void EditCustomer(ActionEvent event) throws IOException {
        // call modify Customer view 
        FXMLLoader loaderPart = new FXMLLoader();
        loaderPart.setLocation(getClass().getResource("/view/EditCustomer.fxml"));
        loaderPart.load();
        // send selected row into modify part controller view
       EditCustomerController ModPartControl = loaderPart.getController();
       ModPartControl.sendCustomer(CustomerTableView.getSelectionModel().getSelectedItem());
       stage = (Stage)((Button)event.getSource()).getScene().getWindow();
       Parent runner = loaderPart.getRoot();
       stage.setScene(new Scene(runner));
       stage.show();
    }
      @FXML
    void ReturnMain(ActionEvent event) throws IOException {
      
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @FXML
    void SearchCostumer()throws IOException{
        Customers.removeCostumerSearch();
        for(Customers temp2 : Customers.getAllCustomers()){
            String name = String.valueOf(SearchField.getText().toUpperCase());
            String Cname = String.valueOf(temp2.getCustomerName().toUpperCase());
            System.out.println(name);
            System.out.println(Cname);
            
            if(Cname.contains(name)){
                Customers.AddCustomerSearch(temp2);
            }// end if 
        }// end for 
        CustomerTableView.setItems(Customers.getCostumerSearch());
        
    }// end searchcostumers
  
}
