package by.epamtc.calendar;

import java.util.*;

public class MyCalendar {
    private GregorianCalendar gregorianCalendar = new GregorianCalendar();
    private GregorianCalendar day = new GregorianCalendar();


    public String[][] month(int year, int month) {
        String[][] calStr = new String[7][7];
        gregorianCalendar.set(Calendar.YEAR, year);
        gregorianCalendar.set(Calendar.MONTH, month - 1);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
        day.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        for (int i = 0; i < calStr[0].length; i++) {
            calStr[0][i] = day.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
            day.add(Calendar.DAY_OF_WEEK, 1);
        }

        int temp = 0;
        for (int i = 1; i < calStr.length; i++) {
            for (int j = 0; j < calStr[i].length; j++) {

                if (gregorianCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US).equals(calStr[0][j]) &&
                        temp < gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {

                    calStr[i][j] = String.valueOf(gregorianCalendar.get(Calendar.DAY_OF_MONTH));
                    gregorianCalendar.roll(Calendar.DAY_OF_MONTH, 1);
                    temp++;

                } else {
                    calStr[i][j] = "";
                }
            }
        }

//
        return calStr;
    }

    public String[][][] year(int year) {
        String[][][] months = new String[12][7][7];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = month(year, i);
        }
        return months;
    }

    public void printMonth(int year, int month) {
        String[][] calStr = month(year, month);
        System.out.println("            " + gregorianCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
        for (String[] str : calStr) {
            for (String s : str) {
                System.out.printf("%4s", s);
            }
            System.out.println();
        }
    }

    public void printYear(int year) {
        String[][][] months = year(year);
        System.out.printf("%65s%n", year);
        for (int i = 0; i < 12; i = i + 4) {
            gregorianCalendar.set(Calendar.MONTH, i);
            for (int monthNumber = i; monthNumber < i + 4; monthNumber++) {
                System.out.printf("%24s", gregorianCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
                System.out.printf("%3s", " ");
                gregorianCalendar.roll(Calendar.MONTH, 1);
            }
            System.out.println();
            for (int row = 0; row < 7; row++) {
                for (int month = i; month < i + 4; month++) {

                    for (int col = 0; col < 7; col++) {
                        System.out.printf("%4s", months[month][row][col]);
                    }
                    System.out.printf("%3s", " ");

                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
