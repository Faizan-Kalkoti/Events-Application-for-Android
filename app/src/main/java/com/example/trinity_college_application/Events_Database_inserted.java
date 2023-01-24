package com.example.trinity_college_application;

public class Events_Database_inserted {

    String name, description, day, month;
    String classes, number;
    String year;


    public Events_Database_inserted(String name, String description, String classes, String month, String day,String year, String number) {
        this.name = name;
        this.description = description;
        this.day = day;
        this.month = month;
        this.classes = classes;
        this.year = year;
        this.number= number;

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
