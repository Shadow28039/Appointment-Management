/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shado
 */
public class User {
    int userId;
    String userName;
    String password;
    LocalDateTime createDate; 
    String createdBy;
    Timestamp lastUpdate;
    String lastUpdateBy;
    String TimeZone;
    private static ObservableList<User> UserData = FXCollections.observableArrayList();

    public User(int userId, String userName, String password, LocalDateTime createDate ,String createdBy,
            Timestamp lastUpdate,String lastUpdateBy, String TimeZone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.TimeZone = TimeZone;
       
    }
    public void setuserID(int userId) {
        this.userId = userId;
    }
    public int getuserID() {
        return userId;
    }
    public void setUserName(String Username) {
        this.userName = Username;
    }
    public String getUserName() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setcreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getcreateDate() {
        return createDate;
    }
    public void setcreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getcreatedBy() {
        return createdBy;
    }
    public void setlastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Timestamp getlastUpdate() {
        return lastUpdate;
    }
    public void setlastUpdatedBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    public String getlastUpdateBy() {
        return lastUpdateBy;
    }
    public static void addUser(User added)
    {
    UserData.add(added);
    }
    public static ObservableList<User> getAllUsers()
    {
        return UserData;
    }// end return all parts
    public void setUserTimeZone(String TimeZone)
    {
        this.TimeZone = TimeZone; 
    }
    public String getUserTimeZone()
    {
        return TimeZone;
    }
    
}// end user java
 
            

