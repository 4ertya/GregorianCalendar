package by.epamtc.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MyCalendar {
   private String[][] calStr = new String[7][7];
   private GregorianCalendar gregorianCalendar = new GregorianCalendar();
   private GregorianCalendar day = new GregorianCalendar();


    public void month(int year, int month) {
        gregorianCalendar.set(Calendar.YEAR, year);
        gregorianCalendar.set(Calendar.MONTH, month-1);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        day.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        for (int i = 0; i < calStr[0].length; i++) {
            calStr[0][i] = day.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,Locale.US);
            day.add(Calendar.DAY_OF_WEEK, 1);
        }

        int temp = 0;
        for (int i = 1; i < calStr.length; i++) {
            for (int j = 0; j < calStr[i].length; j++) {

                if (gregorianCalendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,Locale.US).equals(calStr[0][j]) &&
                        temp < gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {

                    calStr[i][j] = String.valueOf(gregorianCalendar.get(Calendar.DAY_OF_MONTH));
                    gregorianCalendar.roll(Calendar.DAY_OF_MONTH, 1);
                    temp++;

                } else {
                    calStr[i][j] = "";
                }
            }
        }

        System.out.println("            "+gregorianCalendar.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.US));
        for (String[] str : calStr) {
            for (String s : str) {
                System.out.printf("%4s", s);
            }
            System.out.println();
        }
    }

    public void year(int year){
        for (int i=1;i<=12;i++){
            month(year,i);
        }
    }
}
