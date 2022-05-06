/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author shado
 */
public class DailyAppForMonthCalender {

    String date;
    Stage stage;
    Parent scene;
    private static ObservableList<DailyAppForMonthCalender> Data = FXCollections.observableArrayList();

    public DailyAppForMonthCalender(String date) {
        this.date = date;
    }
    public void setdate(String date) {
        this.date = date;
    }

    public String getdate() {
        return date;
    }

    public static void addDates(DailyAppForMonthCalender added) {
        Data.add(added);
    }

    public static ObservableList<DailyAppForMonthCalender> getAllDates() {
        return Data;
    }

    public static void passDate(String tempdate) {
        String Stringtemp = tempdate;

        DailyAppForMonthCalender temp = new DailyAppForMonthCalender(Stringtemp);
        DailyAppForMonthCalender.addDates(temp);
    }
    public static LocalDate returnNeededDate(String button)
    {   
        
        LocalDate value = LocalDate.now();
        ArrayList<String> returnDate = new ArrayList<String>();
        for(DailyAppForMonthCalender temp : DailyAppForMonthCalender.getAllDates())
        {
        returnDate.add(temp.getdate());
        }
        
        switch(button)
        {
            case"row1column1":
            // index 0
            value = LocalDate.parse(returnDate.get(0));
            break;
            case"row1column2":
            // index 1
            value = LocalDate.parse(returnDate.get(1));
            break;
            case"row1column3":
            // index 2
            value = LocalDate.parse(returnDate.get(2));
            break;
            case"row1column4":
            //index 3
             value = LocalDate.parse(returnDate.get(3));
            break;
            case"row1column5":
            //index 4
            value = LocalDate.parse(returnDate.get(4));
            break;
            case"row1column6":
            //index 5
            value = LocalDate.parse(returnDate.get(5));
            break;
            case"row1column7":
            //index 6
            value = LocalDate.parse(returnDate.get(6));
            break;
            case"row2column1":
            //index 7
            value = LocalDate.parse(returnDate.get(7));
            break;
            case"row2column2":
            //index 8
            value = LocalDate.parse(returnDate.get(8));
            break;
            case"row2column3":
            //index 9
            value = LocalDate.parse(returnDate.get(9));  
            break;
            case"row2column4":
            //index 10
            value = LocalDate.parse(returnDate.get(10));
            break;
            case"row2column5":
            //index 11
            value = LocalDate.parse(returnDate.get(11));
            break;
            case"row2column6":
            //index 12
            value = LocalDate.parse(returnDate.get(12));
            break;
            case"row2column7":
            //index 13
            value = LocalDate.parse(returnDate.get(13));
            break;
            case"row3column1":
            //index 14
            value = LocalDate.parse(returnDate.get(14));
            break;
            case"row3column2":
            //index 15
            value = LocalDate.parse(returnDate.get(15));
            break;
            case"row3column3":
            //index 16
            value = LocalDate.parse(returnDate.get(16));
            break;
            case"row3column4":
            //index 17
            value = LocalDate.parse(returnDate.get(17));
            break;
            case"row3column5":
            //index 18
            value = LocalDate.parse(returnDate.get(18));
            break;
            case"row3column6":
            //index 19
            value = LocalDate.parse(returnDate.get(19));
            break;
            case"row3column7":
            //index 20
            value = LocalDate.parse(returnDate.get(20));
            break;
            case"row4column1":
            //index 21
            value = LocalDate.parse(returnDate.get(21));
            break;
            case"row4column2":
            //index 22
            value = LocalDate.parse(returnDate.get(22));
            break;
            case"row4column3":
            //index 23
            value = LocalDate.parse(returnDate.get(23));
            break;
            case"row4column4":
            //index 24
            value = LocalDate.parse(returnDate.get(24));
            break;
            case"row4column5":
            //index 25
            value = LocalDate.parse(returnDate.get(25));
            break;
            case"row4column6":
            //index 26
            value = LocalDate.parse(returnDate.get(26));
            break;
            case"row4column7":
            //index 27
            value = LocalDate.parse(returnDate.get(27));
            break;
            case"row5column1":
            //index 28
            value = LocalDate.parse(returnDate.get(28));
            break;
            case"row5column2":
            //index 29
            value = LocalDate.parse(returnDate.get(29));
            break;
            case"row5column3":
            //index 30
            value = LocalDate.parse(returnDate.get(30));
            break;
            case"row5column4":
            //index 31
            value = LocalDate.parse(returnDate.get(31));
            break;
            case"row5column5":
            //index 32
            value = LocalDate.parse(returnDate.get(32));
            break;
            case"row5column6":
            //index 33
            value = LocalDate.parse(returnDate.get(33));
            break;
            case"row5column7":
            //index 34
            value = LocalDate.parse(returnDate.get(34));
            break;
            case"row6column1":
            //index 35
            value = LocalDate.parse(returnDate.get(35));
            break;
            case"row6column2":
            //index 36
            value = LocalDate.parse(returnDate.get(36));
            break;
            case"row6column3":
            //index 37
            value = LocalDate.parse(returnDate.get(37));
            break;
            case"row6column4":
            //index 38
            value = LocalDate.parse(returnDate.get(38));
            break;
            case"row6column5":
            //index 39
            value = LocalDate.parse(returnDate.get(39));
            break;
            case"row6column6":
            //index 40
            value = LocalDate.parse(returnDate.get(40));
            break;
            case"row6column7":
            //index 41
            value = LocalDate.parse(returnDate.get(41));
            break;
            
        }
        return value;
    }
}// end main
