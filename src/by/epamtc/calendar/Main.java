package by.epamtc.calendar;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MyCalendar myCalendar = new MyCalendar();
        myCalendar.printMonth(2020, 7);
        myCalendar.printYear(2020);

    }


}
