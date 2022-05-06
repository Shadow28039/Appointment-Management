/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.TimeZoneController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 *
 * @author shado
 */
public class Utility {
    // JDBC URL(3 part)

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    //combine
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "passw0rd!"; // Password
    public static Connection connection;  // Connection Interface
    int customer;

    public static Connection runDBAconnect() {

        try {
            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
            return connection;

        } // end runDBAconnect
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void addCustomerToDatabase(int CustomerId, String CustomerName, String Address,String Address2,String Zipcode,String City, String Phone, int active, Timestamp createDate,
            String CreatedBy, Timestamp Update, String UpdateBy) throws SQLException {
        System.out.println(CustomerId + "" + CustomerName + "" + Address + "" + active + "" + CreatedBy);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Statement check1;
        try (Connection verify = runDBAconnect()) {
            check1 = verify.createStatement();
            // create sql statment
            
            String stat ="INSERT into customers(Customer_Name,Address,Address2,Zip_Code,City,Phone,Active,Create_Date,Created_By,Last_Update,Last_Updated_By)"+
            "VALUES('"+CustomerName+"','"+Address+"','"+Address2+"','"+Zipcode+"','"+City+"','"+Phone+"','"+active+"',"+null+",'"+CreatedBy+"',"+null+",'"+UpdateBy+"');";
            System.out.println(stat);
            check1.executeUpdate(stat);
        }
        check1.close();
        Customers temp = new Customers(CustomerId, CustomerName, Address,Address2,Zipcode,Phone,City, active, createDate, CreatedBy, Update, UpdateBy);
        Customers.addCustomer(temp);
    }// end save 

    public static void UpdateCustomerToDatabase(int CustomerId, String CustomerName, String Address,String Address2,String Zipcode,String City, String Phone, int active, Timestamp createDate,
            String CreatedBy, Timestamp Update, String UpdateBy) throws SQLException {
        Statement check1;
        try (Connection verify = runDBAconnect()) {
            check1 = verify.createStatement();
            // create sql statment
            String stat = "UPDATE customers Set Customer_Name = '"+CustomerName+"', Address = '"+Address+"',Address2 = '"+Address2+"',Zip_Code = '"+Zipcode+"',City = '"+City+"',Phone = '"+Phone+"',Active = '"+active+"', Last_Update = '"+Update+"',Last_Updated_By = '"+UpdateBy+ 
            "' WHERE Customer_Id = '"+CustomerId+"';";
            check1.executeUpdate(stat);
            System.out.println("Customer info updated");
            int index = -1;
            // create temp with new values 
            Customers temp = new Customers(CustomerId,CustomerName,Address,Address2,Zipcode,City,Phone,active,createDate,
            CreatedBy,Update,UpdateBy);
            // locate customer data in object
            for (Customers check : Customers.getAllCustomers()) {
                index++;
                if (check.getCustomerId() == CustomerId) {
                    // replace data in object
                    Customers.getAllCustomers().set(index, temp);
                }// end inner if
            }// end for 
        }
        check1.close();

    }// end save 

    public static void DeleteCustomerFromDatabase(int ID) throws SQLException {
        Statement check1;
        try (Connection verify = runDBAconnect()) {
            check1 = verify.createStatement();
            // create sql statment
            String stat = "delete from customers where Customer_ID ='" + ID + "';";
            check1.executeUpdate(stat);
            System.out.println("Customer info Deleted");
            // close connection to database.
        }
        check1.close();
        int index = -1;
        for (Customers check : Customers.getAllCustomers()) {
            index++;
            if (check.getCustomerId() == ID) {
                // replace data in object
                Customers.getAllCustomers().remove(index);
            }// end inner if
        }// end for 

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////Appointment methods //////////////////////////////////////////////////////////////////////////////////////////

    public static void addAppointment(int appointmentId, int customerId, int userid, String title, String description, String location, String contact, String type,
            String url, LocalDateTime start, LocalDateTime end, String createdBy, Timestamp lastUpdate, String lastUpdateBy) throws SQLException {
        TimeZoneController zoner = new TimeZoneController();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        LocalDateTime CreateDate = LocalDateTime.now();

        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        // create sql statment
        String stat = "INSERT INTO appointments(title,description,location,type,url,start,end,createDate,createdBy,"
                + "Last_Updated_By,customerId,userId)"
                + "VALUES("+ "'" + title + "'" + ",'" + description + "'," + "'" + location + "'" + ",'"+ type + "',"
                + "'" + url + "','" + zoner.TimeZoneCode(start) + "','" + zoner.TimeZoneCode(end) + "','"
                + CreateDate + "','" +createdBy+ "','" + lastUpdateBy + "','" + customerId + "','"+userid+ "');";
        System.out.println(stat);
        check1.executeUpdate(stat);
        // close connection to database.
        verify.close();
        check1.close();
        Appointments temp = new Appointments(appointmentId, customerId, userid, title, description, location, type, url, start,
                end, CreateDate, createdBy,lastUpdateBy);
        Appointments.addAppointment(temp);
    }// end add appointment

    public static void UpdateAppointment(int appointmentId, int customerId, int userid, String title, String description, String location, String contact, String type,
            String url, LocalDateTime start, LocalDateTime end, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) throws SQLException {
        TimeZoneController zoner = new TimeZoneController();
        System.out.println(customerId);
        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        String stat = "UPDATE appointments Set title =" + "'" + title + "'" + "," + "description =" + "'" + description + "'"
                + "," + "location =" + "'" + location + "'" + "," + "type =" + "'" + type + "'" + "," + "url =" + "'" + url + "'" + ","
                + "start =" + "'" + zoner.TimeZoneCode(start) + "'," + "end =" + "'" + zoner.TimeZoneCode(end) + "'" + "," + "Last_Updated_By =" + "'" + lastUpdateBy + "'" + "WHERE appointmentId =" + appointmentId + ";";
        System.out.println(stat);
        check1.executeUpdate(stat);

        System.out.println("Update successful");
        // close connection to database.
        check1.close();
        verify.close();
        int index = -1;
        // locate city data in object
        Appointments temp = new Appointments(appointmentId, customerId, userid, title, description, location, type,
                url, start, end, createDate, createdBy, lastUpdateBy);

        for (Appointments check : Appointments.getAllAppointments()) {
            index++;
            if (check.getAppointmentID() == appointmentId) {
                System.out.println("appoint id " + appointmentId + " custid " + customerId + " userid " + userid + " title " + title + " description " + description + " location " + location + " contact " + contact + " type " + type
                        + " url " + url + " start " + start + " end " + end + " createdate " + createDate + " createby " + createdBy + " lastupdate " + lastUpdate + " lastupdateby " + lastUpdateBy);
                // replace data in object
                Appointments.getAllAppointments().set(index, temp);
            }// end inner if
        }// end for 

    }
    //-----------

    public static void DeleteAppointmentFromDatabase(int ID) throws SQLException {
        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        // create sql statment
        String stat = "delete from appointments where appointmentId ='" + ID + "';";
        check1.executeUpdate(stat);
        System.out.println("Appointment info Deleted");
        // close connection to database.
        verify.close();
        check1.close();
        int index = -1;
        for (Appointments check : Appointments.getAllAppointments()) {
            index++;
            if (check.getAppointmentID() == ID) {
                // replace data in object
                Appointments.getAllAppointments().remove(index);
            }// end inner if
        }// end for 
    }
    //-------------

    public static void DeleteAssociatedAppointment(int ID) throws SQLException {
        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        // create sql statment
        String stat = "delete from appointments where customerId ='" + ID + "';";
        check1.executeUpdate(stat);
        System.out.println("Appointment info Deleted");
        // close connection to database.
        verify.close();
        check1.close();
        int index = -1;
        for (Appointments check : Appointments.getAllAppointments()) {
            index++;
            if (check.getCustomerID() == ID) {
                // replace data in object
                Appointments.getAllAppointments().remove(index);
            }// end inner if
        }// end for 
    }

    /////////////////////////////////////////////////////call database for city objects ///////////////////////////////////////////////////////////////////////////////
    public static void verifyUser(String textfield1, String textfield2) throws SQLException {
        int found = 0;
        Connection verify = runDBAconnect();
        Statement check = verify.createStatement();
        // create sql statment
        String stat = "SELECT * FROM users";
        //execute sql statement
        ResultSet checkrun = check.executeQuery(stat);
        while (checkrun.next()) {
            int userid = checkrun.getInt("userId");
            String username = checkrun.getString("username");
            String password = checkrun.getString("password");
            LocalDateTime datetime = checkrun.getTimestamp("createDate").toLocalDateTime();
            String createdBy = checkrun.getString("createdBy");
            Timestamp lastUpdate = checkrun.getTimestamp("lastUpdate");
            String lastUpdateBy = checkrun.getString("lastUpdateBy");
            //get Calendar instance
            Calendar now = Calendar.getInstance();
            //get current TimeZone using getTimeZone method of Calendar class
            TimeZone TZone = now.getTimeZone();
            String TimeZone = TZone.getDisplayName();

            if (username.equals(textfield1) && password.equals(textfield2)) {
                System.out.println("user authenticated");
                found = 1;
                User newuser = new User(userid, username, password, datetime, createdBy, lastUpdate, lastUpdateBy, TimeZone) {
                };
                User.addUser(newuser);

            }// end if 
        }//end while 
        if (found == 0) {
         
            String output = "User Not Found";

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText(output);
            alert.showAndWait();

        }// end if 
        // close database connection 
        check.close(); // statement
        verify.close();// connect

    }// end method
    /////////////////////////////////////////////////////////////////////////

    public static void verifyAppointments(int textfield1) throws SQLException {
        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        // create sql statment
        String stat = "SELECT * FROM appointments Where userId = '" + textfield1 + "';";
        //execute sql statement
        ResultSet checkrun1 = check1.executeQuery(stat);
        while (checkrun1.next()) {
            int appointmentId = checkrun1.getInt("appointmentId");
            //System.out.println(checkrun1.getInt("appointmentId"));
            //System.out.println(checkrun1.getInt("userId"));
            String title = checkrun1.getString("title");
            //System.out.println(checkrun1.getString("title"));
            String description = checkrun1.getString("description");
            //System.out.println(checkrun1.getString("description"));
            String location = checkrun1.getString("location");
            //System.out.println(checkrun1.getString("location"));
            String type = checkrun1.getString("type");
            //System.out.println(checkrun1.getString("type"));
            String url = checkrun1.getString("url");
            //System.out.println(checkrun1.getString("url"));
            LocalDateTime start = checkrun1.getTimestamp("start").toLocalDateTime();
            //System.out.println(checkrun1.getTimestamp("start").toLocalDateTime());
            LocalDateTime end = checkrun1.getTimestamp("end").toLocalDateTime();
            //System.out.println(checkrun1.getTimestamp("end").toLocalDateTime());
            LocalDateTime createDate = checkrun1.getTimestamp("createDate").toLocalDateTime();
            //System.out.println(checkrun1.getTimestamp("createDate").toLocalDateTime());
            String createdBy = checkrun1.getString("createdBy");
            //System.out.println(checkrun1.getString("createdBy"));
            String lastUpdateBy = checkrun1.getString("Last_Updated_By");
            //System.out.println(checkrun1.getString("lastUpdateBy"));
            int customerId = checkrun1.getInt("customerId");
            //System.out.println(checkrun1.getInt("customerId")); 
            int userId = checkrun1.getInt("userId");
            // 2nd check incase of error 
            if (userId == textfield1) {
                Appointments newAppointment = new Appointments(appointmentId, customerId, userId, title, description, location,type, url, start, end, createDate, createdBy,lastUpdateBy) {
                };
                Appointments.addAppointment(newAppointment);

            }// end if   
        }//end while 
        // close connection to database.
        verify.close();
        check1.close();
        // convert time zone 
        //get Calendar instance
    }// end method
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public static void verifyCustomerList() throws SQLException {
        Connection verify = runDBAconnect();
        Statement check1 = verify.createStatement();
        // create sql statment
        String stat = "SELECT * FROM customers";
        //execute sql statement
        ResultSet checkruncustomer = check1.executeQuery(stat);
        while (checkruncustomer.next()) {

            int customerId = checkruncustomer.getInt("Customer_ID");
            //System.out.println(checkruncustomer.getInt("customerId"));
            String CustomerName = checkruncustomer.getString("Customer_Name");
            //System.out.println(checkrun1.getString("customerName"));
            String Address = checkruncustomer.getString("Address");
            String Address2 = checkruncustomer.getString("Address2");
            String Zipcode = checkruncustomer.getString("Zip_Code");
            String City = checkruncustomer.getString("City");
            String Phone = checkruncustomer.getString("Phone");
            //System.out.println(checkruncustomer.getInt("addressId"));
            int active = checkruncustomer.getInt("Active");
            //System.out.println(checkruncustomer.getInt("active"));
            Timestamp createDate = checkruncustomer.getTimestamp("Create_Date");
            String createdBy = checkruncustomer.getString("Created_By");
            //System.out.println(checkruncustomer.getString("createdBy"));
            Timestamp lastUpdate = checkruncustomer.getTimestamp("Last_Update");
            //System.out.println(checkruncustomer.getTimestamp("lastUpdate"));
            String lastUpdateBy = checkruncustomer.getString("Last_Updated_By");
            //System.out.println(checkruncustomer.getString("lastUpdateBy"));

            Customers newCustomer = new Customers(customerId, CustomerName,Address,Address2,Zipcode,City,Phone,active, createDate, createdBy, lastUpdate, lastUpdateBy) {
            };
            Customers.addCustomer(newCustomer);
            // put call for logincontroller hear 
        }// end while
        // close connection to database.
        verify.close();
        check1.close();
    }//end verifycustomerlist

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static String CustomerNameCall(String id) // used for edit appointment using id to retrieve name
    {
        int newid = Integer.parseInt(id);
        String username = "Error:Not_Found";
        for (Customers temp : Customers.getAllCustomers()) {
            if (temp.getCustomerId() == newid) {
                username = temp.getCustomerName();
            }
        }//end for loop 
        return username;
    }// end customer name call method

    public static Integer CustomerIDCall(String name) {

        int id = 0;
        for (Customers temp : Customers.getAllCustomers()) {   // assign temp name to string
            String CustomerName = temp.getCustomerName();
            // compare string to pass in value 
            if (CustomerName.equalsIgnoreCase(name)) { // set the id for specif name 
                id = temp.getCustomerId();

            }
        }// end for
        return id;// return customer id 
    }// end customer id call
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public static String getTimeConvertion(String time) {

        String Htext = time.substring(0, 2);
        String Mtext = time.substring(3, 5);
        String AMPM = "AM";
        int hour = Integer.parseInt(Htext);
        if (hour > 12)// if hour is greater then 12 military time convert time. 13 becomes 1
        {
            hour = hour - 12;
            AMPM = "PM";
            Htext = "0" + String.valueOf(hour);
        }
        time = Htext + ":" + Mtext + AMPM;
        return time;
    }// end time convertion method

    public static String setTimeConvertion(String Time) {
        String Htext = Time.substring(0, 2);

        String Mtext = Time.substring(3, 5);

        String AmPm = Time.substring(5, 7);

        if (AmPm.equalsIgnoreCase("PM")) {
            int temper = Integer.parseInt(Htext);
            temper = temper + 12;
            Htext = String.valueOf(temper);
        }
        String tempTime = Htext + ":" + Mtext;
        return tempTime;
    }

    public static int checkDateInfo(LocalDateTime passValue) {
        String value1 = String.valueOf(passValue);
        String value2;
        int newValue = 0;
        System.out.println(value1);
        for (Appointments rn : Appointments.getAllAppointments()) {
            System.out.println("");
            value2 = String.valueOf(rn.getStart());
            System.out.println(value2);
            if (value1.equals(value2)) {
                newValue = 1;
            }
        }
        System.out.println(newValue);
        return newValue;
    }// end method

}// end class

