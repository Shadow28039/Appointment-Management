/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author shado
 */
public class Customers {
    int CustomerId;
    String CustomerName;
    String Address;
    String Address2;
    String Zipcode;
    String City;
    String Phone;
    int active;
    Timestamp Date;
    String CreatedBy;
    Timestamp Update;
    String UpdateBy;
    int CustomerIdNew;
private static ObservableList<Customers> CustomerData = FXCollections.observableArrayList();
private static ObservableList<Customers> CustomerSearch = FXCollections.observableArrayList();   

public Customers(int CustomerId,String CustomerName,String Address, String Address2, String Zipcode,String City,String Phone,int active,Timestamp Date,
String CreatedBy,Timestamp Update,String UpdateBy){
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.Address = Address;
        this.Address2 = Address2;
        this.Zipcode = Zipcode;
        this.City = City;
        this.Phone = Phone;
        this.active = active;
        this.Date = Date;
        this.CreatedBy = CreatedBy;
        this.Update = Update;
        this.UpdateBy = UpdateBy;  
    }   
public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }
public int getCustomerId() {
        return CustomerId;
    }
public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
public String getCustomerName() {
        return CustomerName;
    }
public void setAddress(String Address) {
        this.Address = Address;
    }
public String getAddress() {
        return Address;
    }
public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }
public String getAddress2() {
        return Address2;
    }
public void setZipcode(String ZipCode) {
        this.Zipcode = ZipCode;
    }
public String getZipCode() {
        return Zipcode;
    }
public void setphone(String Phone) {
        this.Phone = Phone;
    }
public String getphone() {
        return Phone;
    }
public void setcity(String City) {
        this.City = City;
    }
public String getcity() {
        return City;
    }
public void setActive(int active) {
        this.active = active;
    }
public int getActive() {
        return active;
    }
public void setDate(Timestamp Date){
    this.Date = Date;
}
public Timestamp getDate(){
    return Date;
}
public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }
public String getCreatedBy() {
        return CreatedBy;
    }
public void setUpdateBy(String UpdateBy) {
    this.UpdateBy = UpdateBy;
}
public String getUpdateBy() {
    return UpdateBy;
}  
public void setUpdate(Timestamp Update){
    this.Update = Update;
}
public Timestamp getUpdate(){
    return Update;
}
public static int getNextId()
{
        int id = 1;
        /*loop through customers and as long as the retrieved values match the id variables value increase 
          id by 1 until reaching a value that doesnt match the values of customers */
      for(Customers temp : Customers.getAllCustomers())
      {
        if(temp.getCustomerId()== id)
            id++;
      }// 
      return id;
}
public static void removeAllCustomers()
{
        CustomerData.removeAll(CustomerData);
}
public static void removeCostumerSearch(){
    CustomerSearch.removeAll(CustomerSearch);
}
public static boolean DeleteCustomer(Customers remove) throws SQLException
{ // create prompt message to confirm delete
    int id = remove.getCustomerId();
    int choice;
        choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete Customer ID: "+id,"Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(choice == JOptionPane.YES_OPTION)
    {
    Utility.DeleteCustomerFromDatabase(id);
    ////
    return true;
    }
    else if(choice == JOptionPane.NO_OPTION)
    {
    return false;
    }
    return false;
}
public static void AddCustomerSearch(Customers added)
{
    CustomerSearch.add(added);
}

public static void addCustomer(Customers added)
    {
    CustomerData.add(added);
    }
public static ObservableList<Customers> getAllCustomers()
    {
        return CustomerData;
    }// end return all parts
public static ObservableList<Customers> getCostumerSearch()
    {
        return CustomerSearch;
    }

}
