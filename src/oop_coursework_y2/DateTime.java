/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

/**
 *
 * @author ladyg
 */
public class DateTime {
    
    //State: the instance variables
    
    private int day; 
    private int month;
    private int year;
    private int hour;
    private int minutes;  
    private int seconds;  
   
    
    //Constructors
    /* the constructor below to be used for publication entry. As there is no need to 
    record the publication time, just date is required.
    */
    public DateTime()
    {
        this.day = 0;
        this.month = 0; 
        this.year = 0000; 
        hour = 00;
        minutes = 00;
        seconds = 00;
    }
    
    public DateTime(int day, int month, int year)
    { 
        if((day >=1)&&(day<=31)&&(month >=1)&&(month<=12)&&(year>=1455)){
          
            this.day = day;
            this.month = month; 
            this.year = year; 
            hour = 00;
            minutes = 00; 
        }
        else
        {
            System.out.println("The date is not valid");
        }
    }
    /* this constructor is to be used when setting up the date the reader has 
    borrowed the book
    */
    public DateTime(int day, int month, int year, int hour, int minutes)
    { 
        if(((day >=1)&&(day<=31))&&((month >=1)&&(month<=12))&&((year>=1455)))
        {
            
            this.day = day;
            this.month = month; 
            this.year = year; 
            
            if(((hour >= 0)&&(hour <= 23))&&((minutes >= 0)&&(minutes <=59)))
            {
                this.hour = hour;
                this.minutes = minutes; 
                this.seconds = 00; 
            }
            else{System.out.println("Time is wrong");}
        }
        else
        {
            System.out.println("The date is not valid");
        }
    }
    
    public DateTime(int day, int month, int year, int hour, int minutes, int seconds)
    { 
        if(((day >=1)&&(day<=31))&&((month >=1)&&(month<=12))&&((year>=1455)))
        {
           
            this.day = day;
            this.month = month; 
            this.year = year; 
            if(((hour >= 0)&&(hour <= 23))&&((minutes >= 0)&&(minutes <=59))&&((seconds >= 0)&&(seconds <=59)))
            {
                this.hour = hour;
                this.minutes = minutes; 
                this.seconds = seconds; 
            }
            else{System.out.println("Time is wrong");}
        }
        else
        {
            System.out.println("The date is not valid");
        }
    }
    
    //Methods
    //Setters
    
    //this method validates the day input and sets the day; 
    public void setDay(int day)
    {              
        if((month == 1)||(month == 3)||(month == 5)||(month == 7)||(month == 8)||(month == 10)||(month == 12))
        {
            if((day > 0)&&(day<=31)){
                this.day = day; 
            }
            else {System.out.println("Please enter correct day, this month has 31 day");}
        }
        else if((month == 4)||(month == 6)||(month == 9)||(month == 11))
        {
            if((day > 0)&&(day<=30))
            {
                this.day = day; 
            }
            else{System.out.println("Please enter correct day, this month has 30 days");}
        }
        else{
            if((day > 0)&&(day<=29))
            {
                this.day = day; 
        
            }
            else{System.out.println("Please enter correct day, this month has 29 days");}
        }
    }
    
    
    //validates and sets the month
    public void setMonth (int month)
    {
        if((month > 0)&&(month <= 12))
        {
            this.month = month; 
        }
        else{ System.out.println("Please enter correct month"); }
    }
    
    /*validates and sets the year, the acceptable year is 1455 as then was the 
    1st book published */
    public void setYear(int year)
    {
        if((year>=1455))
        {
            this.year = year; 
        }
    }
    
    public void setDate(int day, int month, int year)
    { 
        if((day >=1)&&(day<=31)&&(month >=1)&&(month<=12)&&(year>=1455)){
           
            this.day = day;
            this.month = month; 
            this.year = year; 
            hour = 00;
            minutes = 00; 
        }
        else
        {
            System.out.println("The date is not valid");
        }
    }
    
    //sets and validates the hours
    public void setHour(int hour)
    {
        if((hour >= 00)&&(hour <= 23))
            {
                this.hour = hour;
            }
            else{System.out.println("Given hour is wrong");}
    }
    
    //sets and validates the minutes
    public void setMinutes(int minutes)
    {
        if((minutes >= 00)&&(minutes <=59))
            {
                this.minutes = minutes; 
            }
            else{System.out.println("Minutes given are wrong");}
    }
    
    public void setDateTime(int day, int month, int year, int hour, int minutes)
    { 
        if((day >=1)&&(day<=31)&&(month >=1)&&(month<=12)&&(year>=1455))
        {
            System.out.println("Date added");
            this.day = day;
            this.month = month; 
            this.year = year; 
            if((hour >= 00)&&(hour <= 23)&&(minutes >= 00)&&(minutes <=59))
            {
                this.hour = hour;
                this.minutes = minutes; 
                this.seconds = 00;
            }
            else{System.out.println("Time is wrong");}
        }
        else
        {
            System.out.println("The date is not valid");
        }
    }
    
    //Getters
    public int getDay()
    {
        return day; 
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public int getHour()
    {
        return hour;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public String getDate()
    {
        String date = String.format("%02d/%02d/%04d", day, month, year);
        return date;
    }
    
     public String getTime()
    {
        String time = String.format("%02d:%02d", hour, minutes);
        return time;
    }
    
    public String getDateTime()
    {
        String dateTime = String.format("%02d/%02d/%04d %02d:%02d:%02d",day, month, year, hour, minutes,seconds);
        return dateTime;
    }
    
    //Prints out the class description
    public String toString(){
        String date = String.format("%02d/%02d/%04d", day, month, year);
        String time = String.format("%02d:%02d:%02d", hour, minutes,seconds);
        return date + " " + time;
    }    
}