/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author shado
 */
public class Appointments {
   int appointmentid;
   int customerid;
   int userid;
   String title;
   String description;
   String location;
   String type;
   String url;
   LocalDateTime start;
   LocalDateTime end;
   LocalDateTime createdate;
   String createdby;
   String lastupdateby;
   LocalTime startRecord;
    
    private static ObservableList<Appointments> AppointmentData = FXCollections.observableArrayList();
    private static ObservableList<Appointments> AppointmentToday = FXCollections.observableArrayList(); 
    
    public Appointments(int appointmentId,int customerId,int userid,String title,String description,String location,String type,
            String url, LocalDateTime start,LocalDateTime end,LocalDateTime createDate,String createdBy,String lastUpdateBy) {
        this.appointmentid = appointmentId;
        this.customerid = customerId;
        this.userid = userid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.url = url;
        this.start = start;
        this.end = end;
        this.createdate = createDate;
        this.createdby = createdBy;
        this.lastupdateby = lastUpdateBy;  
    }
public void setAppointmentID(int appointmentId) {
        this.appointmentid = appointmentId;
    }
public int getAppointmentID() {
        return appointmentid;
    }   
public void setCustomerID(int customerId) {
        this.customerid = customerId;
    }
public int getCustomerID() {
        return customerid;
    }
public void setUserID(int userid)
{
    this.userid = userid;
}
public int getUserID()
{
    return userid;
}
public void setTitle(String title) 
{
        this.title = title;
}
public String getTitle() 
{
        return title;
}  
public void setDescription(String description)
{
        this.description = description;
}
public String getDescription() 
{
        return description;
}  
public void setLocation(String location) 
{
        this.location = location;
}
public String getLocation() 
{
        return location;
}   
public void setType(String type) 
{
        this.type = type;
}
public String getType() 
{
        return type;
}  
public void setUrl(String url) 
{
        this.url = url;
}
public String getUrl() 
{
        return url;
}  
public void setStart(LocalDateTime start)
{
    this.start = start;
}
public LocalDateTime getStart()
{
    return start;
}
public void setEnd(LocalDateTime end)
{
    this.end = end;
}
public LocalDateTime getEnd()
{
    return end;
}
public void setCreateDate(LocalDateTime createDate)
{
    this.createdate = createDate;
}
public LocalDateTime getCreateDate()
{
    return createdate;
}
public void setCreatedBy(String createdby)
{
    this.createdby = createdby;
}
public String getcreatedBy()
{
    return createdby;
}
public void setLastUpdateBy(String lastUpdateBy) 
{
        this.lastupdateby = lastUpdateBy;
}
public String getLastUpdateBy() 
{
       return lastupdateby;
}  
///////////////////////////////////////////////////////////////
public static void addAppointment(Appointments added)
{
    AppointmentData.add(added);
}
public static void AddTodayAppointment(Appointments added)
{
    AppointmentToday.add(added);
}
public static int getNextId()
{
   // get numeric size of array 
      int size = Appointments.getAllAppointments().size();
      // add one to size for new id
      int id = size+1; 
      // pass id into id label 
      
return id;
}
public static String getContact(int id){
    String phone = "";   
    for(Customers temp : Customers.getAllCustomers()){
    if(temp.getCustomerId()== id){
        phone = temp.getphone();
    }//end if 
    }//end for 
    return phone;
}
public static boolean DeleteAppointment(Appointments remove) throws SQLException
{ // verify with user that slection is correct 
int id = remove.getAppointmentID();
    int choice;
        choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete Appointment ID: "+id,"Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(choice == JOptionPane.YES_OPTION)
    {
        // if user selects yes call for database removal 
    Utility.DeleteAppointmentFromDatabase(id);
    ////
    return true;
    }
    else if(choice == JOptionPane.NO_OPTION)
    {
    return false;
    }
    return false;
    }
    /**
     *
     * @return
     */
    public static ObservableList<Appointments> getAllAppointments()
    {
        return AppointmentData;
    }// end return all appointments
    public static ObservableList<Appointments> getAllToday()
    {
        return AppointmentToday;
    }
    
 
}
