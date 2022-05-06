/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Appointments;
import model.Utility;

/**
 *
 * @author shado
 */
public class calenderController implements Initializable {
////////////////////////////calender dates////////////////////////////////////////////////////

    @FXML
    private Label FIRSTWEEKMON;

    @FXML
    private Label FIRSTWEEKTUE;

    @FXML
    private Label FIRSTWEEKWED;

    @FXML
    private Label FIRSTWEEKTHUR;

    @FXML
    private Label FIRSTWEEKFRI;

    @FXML
    private Label FIRSTWEEKSAT;

    @FXML
    private Label FIRSTWEEKSUN;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label SECONDWEEKMON;

    @FXML
    private Label SECONDWEEKTUE;

    @FXML
    private Label SECONDWEEKWED;

    @FXML
    private Label SECONDWEEKTHUR;

    @FXML
    private Label SECONDWEEKFRI;

    @FXML
    private Label SECONDWEEKSAT;

    @FXML
    private Label SECONDWEEKSUN;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label THIRDWEEKMON;

    @FXML
    private Label THIRDWEEKTUE;

    @FXML
    private Label THIRDWEEKWED;

    @FXML
    private Label THIRDWEEKTHUR;

    @FXML
    private Label THIRDWEEKFRI;

    @FXML
    private Label THIRDWEEKSAT;

    @FXML
    private Label THIRDWEEKSUN;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label FOURTHWEEKMON;

    @FXML
    private Label FOURTHWEEKTUE;

    @FXML
    private Label FOURTHWEEKWED;

    @FXML
    private Label FOURTHWEEKTHUR;

    @FXML
    private Label FOURTHWEEKFRI;

    @FXML
    private Label FOURTHWEEKSAT;

    @FXML
    private Label FOURTHWEEKSUN;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label FIFTHWEEKMON;

    @FXML
    private Label FIFTHWEEKTUE;

    @FXML
    private Label FIFTHWEEKWED;

    @FXML
    private Label FIFTHWEEKTHUR;

    @FXML
    private Label FIFTHWEEKFRI;

    @FXML
    private Label FIFTHWEEKSAT;

    @FXML
    private Label FIFTHWEEKSUN;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label SIXWEEKMON;

    @FXML
    private Label SIXWEEKTUE;

    @FXML
    private Label SIXWEEKWED;

    @FXML
    private Label SIXWEEKTHUR;

    @FXML
    private Label SIXWEEKFRI;

    @FXML
    private Label SIXWEEKSAT;

    @FXML
    private Label SIXWEEKSUN;
    @FXML
    private Label MONTHVALUE;
    //////////////////////////////row appoinments////////////////////////////////////////
    @FXML
    private Label FIRSTROWMONAPPOINTMENTS;
    @FXML
    private Label FIRSTROWTUEAPPOINTMENTS;
    @FXML
    private Label FIRSTROWWEDAPPOINTMENTS;
    @FXML
    private Label FIRSTROWTHURAPPOINTMENTS;
    @FXML
    private Label FIRSTROWFRIAPPOINTMENTS;
    @FXML
    private Label FIRSTROWSATAPPOINTMENTS;
    @FXML
    private Label FIRSTROWSUNAPPOINTMENTS;
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label SECONDROWMONAPPOINTMENTS;
    @FXML
    private Label SECONDROWTUEAPPOINTMENTS;
    @FXML
    private Label SECONDROWWEDAPPOINTMENTS;
    @FXML
    private Label SECONDROWTHURAPPOINTMENTS;
    @FXML
    private Label SECONDROWFRIAPPOINTMENTS;
    @FXML
    private Label SECONDROWSATAPPOINTMENTS;
    @FXML
    private Label SECONDROWSUNAPPOINTMENTS;
////////////////////////////////////////////////////////////////////////////////   
    @FXML
    private Label THIRDROWMONAPPOINTMENTS;
    @FXML
    private Label THIRDROWTUEAPPOINTMENTS;
    @FXML
    private Label THIRDROWWEDAPPOINTMENTS;
    @FXML
    private Label THIRDROWTHURAPPOINTMENTS;
    @FXML
    private Label THIRDROWFRIAPPOINTMENTS;
    @FXML
    private Label THIRDROWSATAPPOINTMENTS;
    @FXML
    private Label THIRDROWSUNAPPOINTMENTS;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label FOURTHROWMONAPPOINTMENTS;
    @FXML
    private Label FOURTHROWTUEAPPOINTMENTS;
    @FXML
    private Label FOURTHROWWEDAPPOINTMENTS;
    @FXML
    private Label FOURTHROWTHURAPPOINTMENTS;
    @FXML
    private Label FOURTHROWFRIAPPOINTMENTS;
    @FXML
    private Label FOURTHROWSATAPPOINTMENTS;
    @FXML
    private Label FOURTHROWSUNAPPOINTMENTS;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label FIFTHROWMONAPPOINTMENTS;
    @FXML
    private Label FIFTHROWTUEAPPOINTMENTS;
    @FXML
    private Label FIFTHROWWEDAPPOINTMENTS;
    @FXML
    private Label FIFTHROWTHURAPPOINTMENTS;
    @FXML
    private Label FIFTHROWFRIAPPOINTMENTS;
    @FXML
    private Label FIFTHROWSATAPPOINTMENTS;
    @FXML
    private Label FIFTHROWSUNAPPOINTMENTS;
////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label SIXTHROWMONAPPOINTMENTS;
    @FXML
    private Label SIXTHROWTUEAPPOINTMENTS;
    @FXML
    private Label SIXTHROWWEDAPPOINTMENTS;
    @FXML
    private Label SIXTHROWTHURAPPOINTMENTS;
    @FXML
    private Label SIXTHROWFRIAPPOINTMENTS;
    @FXML
    private Label SIXTHROWSATAPPOINTMENTS;
    @FXML
    private Label SIXTHROWSUNAPPOINTMENTS;
/////////////////////////////////weekly///////////////////////////////////////////////
    @FXML
    public Label MON8;
    @FXML
    public Label MON8PH;
    @FXML
    public Label MON83;
    @FXML
    public Label MON83PH;
    @FXML
    public Label MON9;
    @FXML
    public Label MON9PH;
    @FXML
    public Label MON93;
    @FXML
    public Label MON93PH;
    @FXML
    public Label MON10;
    @FXML
    public Label MON10PH;
    @FXML
    public Label MON103;
    @FXML
    public Label MON103PH;
    @FXML
    public Label MON1;
    @FXML
    public Label MON1PH;
    @FXML
    public Label MON13;
    @FXML
    public Label MON13PH;
    @FXML
    public Label MON2;
    @FXML
    public Label MON2PH;
    @FXML
    public Label MON23;
    @FXML
    public Label MON23PH;
    @FXML
    public Label MON3;
    @FXML
    public Label MON3PH;
    @FXML
    public Label MON33;
    @FXML
    public Label MON33PH;
    @FXML
    public Label MON4;
    @FXML
    public Label MON4PH;
    @FXML
    public Label MON43;
    @FXML
    public Label MON43PH;
    @FXML
    public Label MON5;
    @FXML
    public Label MON5PH;
    @FXML
    public Label MON53;
    @FXML
    public Label MON53PH;
    ////////////////////
    @FXML
    public Label TUE8;
    @FXML
    public Label TUE8PH;
    @FXML
    public Label TUE83;
    @FXML
    public Label TUE83PH;
    @FXML
    public Label TUE9;
    @FXML
    public Label TUE9PH;
    @FXML
    public Label TUE93;
    @FXML
    public Label TUE93PH;
    @FXML
    public Label TUE10;
    @FXML
    public Label TUE10PH;
    @FXML
    public Label TUE103;
    @FXML
    public Label TUE103PH;
    @FXML
    public Label TUE1;
    @FXML
    public Label TUE1PH;
    @FXML
    public Label TUE13;
    @FXML
    public Label TUE13PH;
    @FXML
    public Label TUE2;
    @FXML
    public Label TUE2PH;
    @FXML
    public Label TUE23;
    @FXML
    public Label TUE23PH;
    @FXML
    public Label TUE3;
    @FXML
    public Label TUE3PH;
    @FXML
    public Label TUE33;
    @FXML
    public Label TUE33PH;
    @FXML
    public Label TUE4;
    @FXML
    public Label TUE4PH;
    @FXML
    public Label TUE43;
    @FXML
    public Label TUE43PH;
    @FXML
    public Label TUE5;
    @FXML
    public Label TUE5PH;
    @FXML
    public Label TUE53;
    @FXML
    public Label TUE53PH;
//////////////////////////////////////////////////////////////////////////////////
    @FXML
    public Label WED8;
    @FXML
    public Label WED8PH;
    @FXML
    public Label WED83;
    @FXML
    public Label WED83PH;
    @FXML
    public Label WED9;
    @FXML
    public Label WED9PH;
    @FXML
    public Label WED93;
    @FXML
    public Label WED93PH;
    @FXML
    public Label WED10;
    @FXML
    public Label WED10PH;
    @FXML
    public Label WED103;
    @FXML
    public Label WED103PH;
    @FXML
    public Label WED1;
    @FXML
    public Label WED1PH;
    @FXML
    public Label WED13;
    @FXML
    public Label WED13PH;
    @FXML
    public Label WED2;
    @FXML
    public Label WED2PH;
    @FXML
    public Label WED23;
    @FXML
    public Label WED23PH;
    @FXML
    public Label WED3;
    @FXML
    public Label WED3PH;
    @FXML
    public Label WED33;
    @FXML
    public Label WED33PH;
    @FXML
    public Label WED4;
    @FXML
    public Label WED4PH;
    @FXML
    public Label WED43;
    @FXML
    public Label WED43PH;
    @FXML
    public Label WED5;
    @FXML
    public Label WED5PH;
    @FXML
    public Label WED53;
    @FXML
    public Label WED53PH;
    ///////////////////////////////////////////////////////////////////////////
    @FXML
    public Label THUR8;
    @FXML
    public Label THUR8PH;
    @FXML
    public Label THUR83;
    @FXML
    public Label THUR83PH;
    @FXML
    public Label THUR9;
    @FXML
    public Label THUR9PH;
    @FXML
    public Label THUR93;
    @FXML
    public Label THUR93PH;
    @FXML
    public Label THUR10;
    @FXML
    public Label THUR10PH;
    @FXML
    public Label THUR103;
    @FXML
    public Label THUR103PH;
    @FXML
    public Label THUR1;
    @FXML
    public Label THUR1PH;
    @FXML
    public Label THUR13;
    @FXML
    public Label THUR13PH;
    @FXML
    public Label THUR2;
    @FXML
    public Label THUR2PH;
    @FXML
    public Label THUR23;
    @FXML
    public Label THUR23PH;
    @FXML
    public Label THUR3;
    @FXML
    public Label THUR3PH;
    @FXML
    public Label THUR33;
    @FXML
    public Label THUR33PH;
    @FXML
    public Label THUR4;
    @FXML
    public Label THUR4PH;
    @FXML
    public Label THUR43;
    @FXML
    public Label THUR43PH;
    @FXML
    public Label THUR5;
    @FXML
    public Label THUR5PH;
    @FXML
    public Label THUR53;
    @FXML
    public Label THUR53PH;
    /////////////////////////////////////////////////////////////////////////
    @FXML
    public Label FRI8;
    @FXML
    public Label FRI8PH;
    @FXML
    public Label FRI83;
    @FXML
    public Label FRI83PH;
    @FXML
    public Label FRI9;
    @FXML
    public Label FRI9PH;
    @FXML
    public Label FRI93;
    @FXML
    public Label FRI93PH;
    @FXML
    public Label FRI10;
    @FXML
    public Label FRI10PH;
    @FXML
    public Label FRI103;
    @FXML
    public Label FRI103PH;
    @FXML
    public Label FRI1;
    @FXML
    public Label FRI1PH;
    @FXML
    public Label FRI13;
    @FXML
    public Label FRI13PH;
    @FXML
    public Label FRI2;
    @FXML
    public Label FRI2PH;
    @FXML
    public Label FRI23;
    @FXML
    public Label FRI23PH;
    @FXML
    public Label FRI3;
    @FXML
    public Label FRI3PH;
    @FXML
    public Label FRI33;
    @FXML
    public Label FRI33PH;
    @FXML
    public Label FRI4;
    @FXML
    public Label FRI4PH;
    @FXML
    public Label FRI43;
    @FXML
    public Label FRI43PH;
    @FXML
    public Label FRI5;
    @FXML
    public Label FRI5PH;
    @FXML
    public Label FRI53;
    @FXML
    public Label FRI53PH;
    /////////////////////////////////////////////////////////////////////////
    @FXML
    public Label SAT8;
    @FXML
    public Label SAT8PH;
    @FXML
    public Label SAT83;
    @FXML
    public Label SAT83PH;
    @FXML
    public Label SAT9;
    @FXML
    public Label SAT9PH;
    @FXML
    public Label SAT93;
    @FXML
    public Label SAT93PH;
    @FXML
    public Label SAT10;
    @FXML
    public Label SAT10PH;
    @FXML
    public Label SAT103;
    @FXML
    public Label SAT103PH;
    @FXML
    public Label SAT1;
    @FXML
    public Label SAT1PH;
    @FXML
    public Label SAT13;
    @FXML
    public Label SAT13PH;
    @FXML
    public Label SAT2;
    @FXML
    public Label SAT2PH;
    @FXML
    public Label SAT23;
    @FXML
    public Label SAT23PH;
    @FXML
    public Label SAT3;
    @FXML
    public Label SAT3PH;
    @FXML
    public Label SAT33;
    @FXML
    public Label SAT33PH;
    @FXML
    public Label SAT4;
    @FXML
    public Label SAT4PH;
    @FXML
    public Label SAT43;
    @FXML
    public Label SAT43PH;
    @FXML
    public Label SAT5;
    @FXML
    public Label SAT5PH;
    @FXML
    public Label SAT53;
    @FXML
    public Label SAT53PH;
    ///////////////////////////////////////////////////////////
    @FXML
    public Label SUN8;
    @FXML
    public Label SUN8PH;
    @FXML
    public Label SUN83;
    @FXML
    public Label SUN83PH;
    @FXML
    public Label SUN9;
    @FXML
    public Label SUN9PH;
    @FXML
    public Label SUN93;
    @FXML
    public Label SUN93PH;
    @FXML
    public Label SUN10;
    @FXML
    public Label SUN10PH;
    @FXML
    public Label SUN103;
    @FXML
    public Label SUN103PH;
    @FXML
    public Label SUN1;
    @FXML
    public Label SUN1PH;
    @FXML
    public Label SUN13;
    @FXML
    public Label SUN13PH;
    @FXML
    public Label SUN2;
    @FXML
    public Label SUN2PH;
    @FXML
    public Label SUN23;
    @FXML
    public Label SUN23PH;
    @FXML
    public Label SUN3;
    @FXML
    public Label SUN3PH;
    @FXML
    public Label SUN33;
    @FXML
    public Label SUN33PH;
    @FXML
    public Label SUN4;
    @FXML
    public Label SUN4PH;
    @FXML
    public Label SUN43;
    @FXML
    public Label SUN43PH;
    @FXML
    public Label SUN5;
    @FXML
    public Label SUN5PH;
    @FXML
    public Label SUN53;
    @FXML
    public Label SUN53PH;
    Stage stage;
    Parent scene;
    LocalDate currentDate = LocalDate.now();
    LocalDate countingDate = LocalDate.now();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // weekly controls 
        DateChecker(currentDate);
    }

    public void DateChecker(LocalDate Valuepass) {
        int count = 1;
        // get todays date
        LocalDate today = Valuepass;
        while (count <= 7) {
            switch (count) {   // monday
                case 1:

                    // use date as reference for monday call
                    LocalDate monday = today.with(DayOfWeek.MONDAY);
                    calltimeMonday(monday);
                    //System.out.println(monday);
                    break;
                case 2:

                    // use date as reference for tuesday call
                    LocalDate tuesday = today.with(DayOfWeek.TUESDAY);
                    calltimeTuesday(tuesday);
                    //System.out.println(tuesday);
                    break;
                case 3:

                    // use date as reference for wednesday call
                    LocalDate wednesday = today.with(DayOfWeek.WEDNESDAY);
                    calltimeWednesday(wednesday);
                    //System.out.println(wednesday);
                    break;
                case 4:

                    // use date as reference for wednesday call
                    LocalDate thursday = today.with(DayOfWeek.THURSDAY);
                    calltimeThursday(thursday);
                    //System.out.println(thursday);
                    break;
                case 5:

                    // use date as reference for wednesday call
                    LocalDate friday = today.with(DayOfWeek.FRIDAY);
                    calltimeFriday(friday);
                    //System.out.println(friday);
                    break;
                case 6:

                    // use date as reference for wednesday call
                    LocalDate saturday = today.with(DayOfWeek.SATURDAY);
                    calltimeSaturday(saturday);
                    //System.out.println(saturday);
                    break;
                case 7:

                    // use date as reference for wednesday call
                    LocalDate sunday = today.with(DayOfWeek.SUNDAY);
                    calltimeSunday(sunday);
                    //System.out.println(sunday);
                    break;
            }// end switch
            count++;// increase count 
        }// end while count 
        //////////////////////////month controls//////////////////////////////////////////////////
        //get month 
        MONTHVALUE.setText(String.valueOf(currentDate.getMonth()));
        //get current days per month
        calenderCall();

    }// end initialize

    @FXML
    void CALLWEEKLYPAGE(ActionEvent event) throws IOException {
        FXMLLoader UserPart = new FXMLLoader();
        UserPart.setLocation(getClass().getResource("/view/WeeklyCalender_1.fxml"));
        UserPart.load();
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent second = UserPart.getRoot();
        stage.setScene(new Scene(second));
        stage.show();
    }// END WEEKLY  PAGE 

    @FXML
    void MainCall(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }// END MAIN CALL

    public void calenderCall() {
        int count = 1;
        LocalDate Temp;
        while (count <= 6) {
            switch (count) {
                // first row 
                case 1:
                    // pass date into method for first row and return new values for countingDate
                    Temp = countingDate.withDayOfMonth(1);
                    countingDate = firstRow(Temp);
                    count++;
                    break;
                case 2:
                    Temp = secondRow(countingDate);
                    countingDate = Temp;
                    count++;
                    break;
                case 3:
                    Temp = thirdRow(countingDate);
                    countingDate = Temp;
                    count++;
                    break;
                case 4:
                    Temp = fourthRow(countingDate);
                    countingDate = Temp;
                    count++;
                    //System.out.println(countingDate);
                    break;
                case 5:
                    Temp = fifthRow(countingDate);
                    countingDate = Temp;
                    //System.out.println(countingDate);
                    count++;
                    break;
                case 6:
                    Temp = sixthRow(countingDate);
                    countingDate = Temp;
                    count++;
                    break;

            }// end switch
        } // end while 
    }// end calender call
    ////////////////////////////////////////////////////////////////////////////

    public LocalDate firstRow(LocalDate countingDate) {
        LocalDate newDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        FIRSTROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        // pass date value into new object
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        FIRSTROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        FIRSTROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        FIRSTROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        FIRSTROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        FIRSTROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        FIRSTROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));
        // set label values 
        FIRSTWEEKMON.setText(mon);
        FIRSTWEEKTUE.setText(tue);
        FIRSTWEEKWED.setText(wed);
        FIRSTWEEKTHUR.setText(thur);
        FIRSTWEEKFRI.setText(fri);
        FIRSTWEEKSAT.setText(sat);
        FIRSTWEEKSUN.setText(sun);

// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
// return new date info
        return newDate;
    }// end first row values
    ////////////////////////////////////////////////////////////////////////////

    public LocalDate secondRow(LocalDate countingDate) {
        LocalDate newDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        SECONDROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        SECONDROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        SECONDROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        SECONDROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        SECONDROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        SECONDROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        SECONDROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));

        // set label values 
        SECONDWEEKMON.setText(mon);
        SECONDWEEKTUE.setText(tue);
        SECONDWEEKWED.setText(wed);
        SECONDWEEKTHUR.setText(thur);
        SECONDWEEKFRI.setText(fri);
        SECONDWEEKSAT.setText(sat);
        SECONDWEEKSUN.setText(sun);

// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
        //System.out.println(newDate);
// return new date info
        return newDate;
    }// end second row 
    /////////////////////////////////////////////////////////////////////////////

    public LocalDate thirdRow(LocalDate countingDate) {

        LocalDate newDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        THIRDROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        THIRDROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        THIRDROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        THIRDROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        THIRDROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        THIRDROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        THIRDROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));

        // set label values 
        THIRDWEEKMON.setText(mon);
        THIRDWEEKTUE.setText(tue);
        THIRDWEEKWED.setText(wed);
        THIRDWEEKTHUR.setText(thur);
        THIRDWEEKFRI.setText(fri);
        THIRDWEEKSAT.setText(sat);
        THIRDWEEKSUN.setText(sun);
// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
// return new date info
        return newDate;
    }// end THIRD row

    public LocalDate fourthRow(LocalDate countingDate) {

        LocalDate newDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        FOURTHROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        FOURTHROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        FOURTHROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        FOURTHROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        FOURTHROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        FOURTHROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        FOURTHROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));

        // set label values 
        FOURTHWEEKMON.setText(mon);
        FOURTHWEEKTUE.setText(tue);
        FOURTHWEEKWED.setText(wed);
        FOURTHWEEKTHUR.setText(thur);
        FOURTHWEEKFRI.setText(fri);
        FOURTHWEEKSAT.setText(sat);
        FOURTHWEEKSUN.setText(sun);
// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
// return new date info
        return newDate;
    }// end FOURTH row

    public LocalDate fifthRow(LocalDate countingDate) {
        LocalDate newDate = countingDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        FIFTHROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        FIFTHROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        FIFTHROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        FIFTHROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        FIFTHROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        FIFTHROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        FIFTHROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));

        // set label values 
        FIFTHWEEKMON.setText(mon);
        FIFTHWEEKTUE.setText(tue);
        FIFTHWEEKWED.setText(wed);
        FIFTHWEEKTHUR.setText(thur);
        FIFTHWEEKFRI.setText(fri);
        FIFTHWEEKSAT.setText(sat);
        FIFTHWEEKSUN.setText(sun);
// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
// return new date info
        return newDate;
    }// end FIFTH row

    public LocalDate sixthRow(LocalDate countingDate) {
        LocalDate newDate;
        LocalDate temp = countingDate;
        int counts;
        // get week value from temp data
        String mon = String.valueOf(temp.with(DayOfWeek.MONDAY));
        mon = mon.substring(8, 10);
        String tue = String.valueOf(temp.with(DayOfWeek.TUESDAY));
        tue = tue.substring(8, 10);
        String wed = String.valueOf(temp.with(DayOfWeek.WEDNESDAY));
        wed = wed.substring(8, 10);
        String thur = String.valueOf(temp.with(DayOfWeek.THURSDAY));
        thur = thur.substring(8, 10);
        String fri = String.valueOf(temp.with(DayOfWeek.FRIDAY));
        fri = fri.substring(8, 10);
        String sat = String.valueOf(temp.with(DayOfWeek.SATURDAY));
        sat = sat.substring(8, 10);
        String sun = String.valueOf(temp.with(DayOfWeek.SUNDAY));
        sun = sun.substring(8, 10);
        // get number of appointments for each day
        counts = AppointmentCount(temp.with(DayOfWeek.MONDAY));
        SIXTHROWMONAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.MONDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.TUESDAY));
        SIXTHROWTUEAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.TUESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.WEDNESDAY));
        SIXTHROWWEDAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.WEDNESDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.THURSDAY));
        SIXTHROWTHURAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.THURSDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.FRIDAY));
        SIXTHROWFRIAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.FRIDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SATURDAY));
        SIXTHROWSATAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SATURDAY)));

        counts = AppointmentCount(temp.with(DayOfWeek.SUNDAY));
        SIXTHROWSUNAPPOINTMENTS.setText("Appointments: " + String.valueOf(counts));
        DailyAppForMonthCalender.passDate(String.valueOf(temp.with(DayOfWeek.SUNDAY)));

        // set label values 
        SIXWEEKMON.setText(mon);
        SIXWEEKTUE.setText(tue);
        SIXWEEKWED.setText(wed);
        SIXWEEKTHUR.setText(thur);
        SIXWEEKFRI.setText(fri);
        SIXWEEKSAT.setText(sat);
        SIXWEEKSUN.setText(sun);

// return new date info for following week 
// get sunday date 
        newDate = temp.with(DayOfWeek.SUNDAY);
// get following monday date 
        newDate = newDate.plusDays(1);
// return new date info
        return newDate;
    }// end six row 

    public int AppointmentCount(LocalDate Date) {
        // take inserted date and counting appointments based on that date 
        int count = 0;
        for (Appointments temp : Appointments.getAllAppointments()) {
            LocalDate check = temp.getStart().toLocalDate(); // get iteration date    
            if (Date.equals(check)) { // compare to passed in date value 
                count++; // increase count by one 
            }// end if 
        } // end for

        return count; // return number of appointments
    }// appointment count 
    ///////////////////////weekly methods////////////////////////////////////////////////////////

    public void calltimeMonday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON8.setText("Apt ID : " + idcheck);
                        MON8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON83.setText("Apt ID : " + idcheck);
                        MON83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON9.setText("Apt ID : " + idcheck);
                        MON9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON93.setText("Apt ID : " + idcheck);
                        MON93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON10.setText("Apt ID : " + idcheck);
                        MON10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON103.setText("Apt ID : " + idcheck);
                        MON103PH.setText(phone);
                        break;
                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON1.setText("Apt ID : " + idcheck);
                        MON1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON13.setText("Apt ID : " + idcheck);
                        MON13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON2.setText("Apt ID : " + idcheck);
                        MON2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON23.setText("Apt ID : " + idcheck);
                        MON23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON3.setText("Apt ID : " + idcheck);
                        MON3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON33.setText("Apt ID : " + idcheck);
                        MON33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON4.setText("Apt ID : " + idcheck);
                        MON4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON43.setText("Apt ID : " + idcheck);
                        MON43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON5.setText("Apt ID : " + idcheck);
                        MON5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        MON53.setText("Apt ID : " + idcheck);
                        MON53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeTuesday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE8.setText("Apt ID : " + idcheck);
                        TUE8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE83.setText("Apt ID : " + idcheck);
                        TUE83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE9.setText("Apt ID : " + idcheck);
                        TUE9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE93.setText("Apt ID : " + idcheck);
                        TUE93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE10.setText("Apt ID : " + idcheck);
                        TUE10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE103.setText("Apt ID : " + idcheck);
                        TUE103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE1.setText("Apt ID : " + idcheck);
                        TUE1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE13.setText("Apt ID : " + idcheck);
                        TUE13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE2.setText("Apt ID : " + idcheck);
                        TUE2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE23.setText("Apt ID : " + idcheck);
                        TUE23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE3.setText("Apt ID : " + idcheck);
                        TUE3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE33.setText("Apt ID : " + idcheck);
                        TUE33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE4.setText("Apt ID : " + idcheck);
                        TUE4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE43.setText("Apt ID : " + idcheck);
                        TUE43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE5.setText("Apt ID : " + idcheck);
                        TUE5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        TUE53.setText("Apt ID : " + idcheck);
                        TUE53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeWednesday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED8.setText("Apt ID : " + idcheck);
                        WED8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED83.setText("Apt ID : " + idcheck);
                        WED83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED9.setText("Apt ID : " + idcheck);
                        WED9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED93.setText("Apt ID : " + idcheck);
                        WED93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED10.setText("Apt ID : " + idcheck);
                        WED10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED103.setText("Apt ID : " + idcheck);
                        WED103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED1.setText("Apt ID : " + idcheck);
                        WED1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED13.setText("Apt ID : " + idcheck);
                        WED13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED2.setText("Apt ID : " + idcheck);
                        WED2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED23.setText("Apt ID : " + idcheck);
                        WED23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED3.setText("Apt ID : " + idcheck);
                        WED3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED33.setText("Apt ID : " + idcheck);
                        WED33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED4.setText("Apt ID : " + idcheck);
                        WED4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED43.setText("Apt ID : " + idcheck);
                        WED43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED5.setText("Apt ID : " + idcheck);
                        WED5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        WED53.setText("Apt ID : " + idcheck);
                        WED53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeThursday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR8.setText("Apt ID : " + idcheck);
                        THUR8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR83.setText("Apt ID : " + idcheck);
                        THUR83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR9.setText("Apt ID : " + idcheck);
                        THUR9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR93.setText("Apt ID : " + idcheck);
                        THUR93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR10.setText("Apt ID : " + idcheck);
                        THUR10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR103.setText("Apt ID : " + idcheck);
                        THUR103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR1.setText("Apt ID : " + idcheck);
                        THUR1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR13.setText("Apt ID : " + idcheck);
                        THUR13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR2.setText("Apt ID : " + idcheck);
                        THUR2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR23.setText("Apt ID : " + idcheck);
                        THUR23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR3.setText("Apt ID : " + idcheck);
                        THUR3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR33.setText("Apt ID : " + idcheck);
                        THUR33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR4.setText("Apt ID : " + idcheck);
                        THUR4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR43.setText("Apt ID : " + idcheck);
                        THUR43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR5.setText("Apt ID : " + idcheck);
                        THUR5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        THUR53.setText("Apt ID : " + idcheck);
                        THUR53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeFriday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI8.setText("Apt ID : " + idcheck);
                        FRI8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI83.setText("Apt ID : " + idcheck);
                        FRI83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI9.setText("Apt ID : " + idcheck);
                        FRI9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI93.setText("Apt ID : " + idcheck);
                        FRI93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI10.setText("Apt ID : " + idcheck);
                        FRI10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI103.setText("Apt ID : " + idcheck);
                        FRI103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI1.setText("Apt ID : " + idcheck);
                        FRI1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI13.setText("Apt ID : " + idcheck);
                        FRI13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI2.setText("Apt ID : " + idcheck);
                        FRI2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI23.setText("Apt ID : " + idcheck);
                        FRI23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI3.setText("Apt ID : " + idcheck);
                        FRI3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI33.setText("Apt ID : " + idcheck);
                        FRI33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI4.setText("Apt ID : " + idcheck);
                        FRI4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI43.setText("Apt ID : " + idcheck);
                        FRI43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI5.setText("Apt ID : " + idcheck);
                        FRI5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        FRI53.setText("Apt ID : " + idcheck);
                        FRI53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeSaturday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            //System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT8.setText("Apt ID : " + idcheck);
                        SAT8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT83.setText("Apt ID : " + idcheck);
                        SAT83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT9.setText("Apt ID : " + idcheck);
                        SAT9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT93.setText("Apt ID : " + idcheck);
                        SAT93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT10.setText("Apt ID : " + idcheck);
                        SAT10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT103.setText("Apt ID : " + idcheck);
                        SAT103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT1.setText("Apt ID : " + idcheck);
                        SAT1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT13.setText("Apt ID : " + idcheck);
                        SAT13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT2.setText("Apt ID : " + idcheck);
                        SAT2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT23.setText("Apt ID : " + idcheck);
                        SAT23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT3.setText("Apt ID : " + idcheck);
                        SAT3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT33.setText("Apt ID : " + idcheck);
                        SAT33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT4.setText("Apt ID : " + idcheck);
                        SAT4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT43.setText("Apt ID : " + idcheck);
                        SAT43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT5.setText("Apt ID : " + idcheck);
                        SAT5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SAT53.setText("Apt ID : " + idcheck);
                        SAT53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for 
// place switch for time values 
    }// end call time

    public void calltimeSunday(LocalDate day) {
        String time = null;
        String phone = null;
        String idcheck = null;
        //System.out.println(day);
// loop through all values
        for (Appointments temp : Appointments.getAllAppointments()) {
            // remove time info from specific iteration. convert to localdate
            LocalDate check = temp.getStart().toLocalDate();
            System.out.println("for: " + check);
            // check if day matches start date.
            if (day.equals(check)) {   // get string value of start time if the day info matches 

                time = String.valueOf(temp.getStart().toLocalTime());
                phone = temp.getContact(temp.getCustomerID());
                //System.out.println("if worked ");
                // pass time into switch
                switch (time) {
                    case "08:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN8.setText("Apt ID : " + idcheck);
                        SUN8PH.setText(phone);
                        break;
                    case "08:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN83.setText("Apt ID : " + idcheck);
                        SUN83PH.setText(phone);
                        break;
                    case "09:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN9.setText("Apt ID : " + idcheck);
                        SUN9PH.setText(phone);
                        break;
                    case "09:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN93.setText("Apt ID : " + idcheck);
                        SUN93PH.setText(phone);
                        break;
                    case "10:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN10.setText("Apt ID : " + idcheck);
                        SUN10PH.setText(phone);
                        break;
                    case "10:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN103.setText("Apt ID : " + idcheck);
                        SUN103PH.setText(phone);
                        break;

                    case "13:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN1.setText("Apt ID : " + idcheck);
                        SUN1PH.setText(phone);
                        break;
                    case "13:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN13.setText("Apt ID : " + idcheck);
                        SUN13PH.setText(phone);
                        break;
                    case "14:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN2.setText("Apt ID : " + idcheck);
                        SUN2PH.setText(phone);
                        break;
                    case "14:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN23.setText("Apt ID : " + idcheck);
                        SUN23PH.setText(phone);
                        break;
                    case "15:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN3.setText("Apt ID : " + idcheck);
                        SUN3PH.setText(phone);
                        break;
                    case "15:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN33.setText("Apt ID : " + idcheck);
                        SUN33PH.setText(phone);
                        break;
                    case "16:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN4.setText("Apt ID : " + idcheck);
                        SUN4PH.setText(phone);
                        break;
                    case "16:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN43.setText("Apt ID : " + idcheck);
                        SUN43PH.setText(phone);
                        break;
                    case "17:00":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN5.setText("Apt ID : " + idcheck);
                        SUN5PH.setText(phone);
                        break;
                    case "17:30":
                        idcheck = String.valueOf(temp.getAppointmentID());
                        // set the label values 
                        SUN53.setText("Apt ID : " + idcheck);
                        SUN53PH.setText(phone);
                        break;
                }// end switch
            } // end if statement 
        }// end for   
          
// place switch for time values 
    }// end call time

    @FXML
    void CallMain(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }// END MAIN

    @FXML
    void CALLMONTHLYPAGE(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Monthly.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }// end monthly 
    // page info 

    @FXML
    void getRowgetColumn(MouseEvent event) {
        // get row column info to pass into next method 
        String source1 = event.getSource().toString();
        //String source1 = event.getPickResult().toString(); //yields complete string
        //System.out.println(source1);
        source1 = source1.substring(42);
        //System.out.println(String.valueOf(source1));
        getAppointmentInfo(source1);
    }

    @FXML
    void getAppointmentInfo(String pass) {
        // remove all special characters and convert to int
        int id = Integer.parseInt(pass.replaceAll("[^a-zA-Z0-9]", ""));
        //System.out.println(id);
        for (Appointments temp : Appointments.getAllAppointments()) {   // if values match create alert message with app info 
            if (temp.getAppointmentID() == id) {
                String date = String.valueOf(temp.getStart());
                date = date.substring(0, 10);
                String startTime = String.valueOf(temp.getStart());
                startTime = startTime.substring(11);
                String endTime = String.valueOf(temp.getEnd());
                endTime = endTime.substring(11);
                String CustomerName = Utility.CustomerNameCall(String.valueOf(temp.getCustomerID()));
                // output message with app details 
                JOptionPane.showMessageDialog(null,
                        "Meeting Title: " + temp.getTitle() + "\n"
                        + "Meeting Date: " + date + "\n"
                        + // date
                        "Meeting Start Time: " + startTime + "\n"
                        + // times    
                        "Meeting End Time: " + endTime + "\n"
                        + "Customer Name: " + CustomerName + "\n"
                        +// convert name
                        "Location: " + temp.getLocation() + "\n"
                        + "Type: " + temp.getType() + "\n"
                        //+ "Info: " + temp.getContact() + "\n"
                        + "Description: " + temp.getDescription()
                );
            }// end if 
        }// end for loop 
    }// end method

    @FXML
    public void passToSpecific(ActionEvent event) throws IOException {
        
        String source1 = event.getSource().toString();
        source1 = source1.substring(10,21);
        // call modify Customer view 
        System.out.println(source1);
        //take returned date and pass into local date value
        LocalDate temp = DailyAppForMonthCalender.returnNeededDate(source1);
        System.out.println(String.valueOf(temp));
        FXMLLoader loaderPart = new FXMLLoader();
        loaderPart.setLocation(getClass().getResource("/view/specificdate.fxml"));
        loaderPart.load();
        // send selected row into modify part controller view
        SpecificdateController ModAppControl = loaderPart.getController();
        ///////////pass specific value in 
        ModAppControl.setdate(temp);
        // reset table before calling to avoid repeat data 
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent runner = loaderPart.getRoot();
        stage.setScene(new Scene(runner));
        stage.show();
       
    }
}    // end main

