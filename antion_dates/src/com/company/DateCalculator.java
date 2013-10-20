package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 10/19/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */

public class DateCalculator {

    private Scanner scan = new Scanner(System.in);
    private String event, person;
    private GregorianCalendar date1, date2;
    private GregorianCalendar date3 = new GregorianCalendar();
    private int day, month, year, days, months, years;

    public DateCalculator(){
        getCalcFunction();
    }

    public void getCalcFunction(){
        System.out.println("What would you like to do?\n"+
        "Enter 1 for Age Calculation\n" +
        "Enter 2 for Anniversary Calculation\n" +
        "Enter 3 for Age Difference Calculation");

         String FunctionInput = scan.next();

        if(FunctionInput.equals("1")){
            System.out.println("You chose 1");
            event = " birthday";
            person ="your";
            date1 = askForDate();
            date2 = getTodaysDate();
            performCalc();
            System.out.println("They are "+years+ " Years, "+months+" Months and "+days+" Days old.");
        }
        else if(FunctionInput.equals("2")){
            System.out.println("You chose 2");
            event = " Anniversary";
            person="your";
            date1 = getTodaysDate();
            date2 = getAnniversaryDate();
            performCalc();
            System.out.println("They are "+months+" Months and "+days+" days until your next anniversary.");

        }
        else if(FunctionInput.equals("3")){
            System.out.println("You chose 3");
            event = " birthday";
            person = "the older person's ";
            date1 = askForDate();
            person = "the younger person's";
            date2 = askForDate();
            performCalc();
            System.out.println("There is a "+years+ " Year, "+months+" Month and "+days+" Day difference.");
        }
        else{
            System.out.println("Please Enter 1,2 or 3");
            getCalcFunction();
        }
        System.out.println("Would you like to preform another calculation? 1 for yes, anything else for no.");
        String again = scan.next();
        if(again.equals("1")){
            getCalcFunction();
        }
        else {
            System.exit(1);
        }

    }

    public GregorianCalendar askForDate(){
        System.out.println("Please enter " + person + event + ".\n" +
                "Year: ");
        year = scan.nextInt();
        System.out.println("Month: ");
        month = scan.nextInt();
        System.out.println("Day: ");
        day = scan.nextInt();

       return new GregorianCalendar(year, month, day);

    }

    public GregorianCalendar getTodaysDate(){
        return new GregorianCalendar();
    }

    public GregorianCalendar getAnniversaryDate(){
        System.out.println("Please enter " + person + event + ".\n" +
                "Month: ");
        month = scan.nextInt();
        System.out.println("Day: ");
        day = scan.nextInt();
        GregorianCalendar temp = new GregorianCalendar();
        if(month>=temp.get(Calendar.MONTH)){
            if(day>=temp.get(Calendar.DAY_OF_MONTH))
            year = temp.get(Calendar.YEAR);
        }
        else{
            year = temp.get(Calendar.YEAR+1);
        }
        return new GregorianCalendar(year,month-1, day);
    }
    public void performCalc(){

        date2.add(Calendar.YEAR, -date1.get(Calendar.YEAR));
        date2.add(Calendar.MONTH, -date1.get(Calendar.MONTH));
        date2.add(Calendar.DAY_OF_MONTH, -date1.get(Calendar.DAY_OF_MONTH));

        years = date2.get(Calendar.YEAR);
        months = date2.get(Calendar.MONTH);
        days = date2.get(Calendar.DAY_OF_MONTH)-1;
    }

}
