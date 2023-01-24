package com.example.trinity_college_application;

public class Eventsmodel {

    private final String Number, Title, day, month,year, Description;
   private final String classes;


    public Eventsmodel(String number, String title, String date,String classes, String month,String year, String description) {
        this.Number = number;
        this.Title = title;
        this.day = date;
        this.month = month;
        this.year = year;
        this.classes = classes;
        this.Description = description;
    }
    public String getNumber() {
        return Number;
    }

    public String getTitle() {
        return Title;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return Description;
    }

    public String getClasses() {
        return classes;
    }

}
