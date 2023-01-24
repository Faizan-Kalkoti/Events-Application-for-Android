package com.example.trinity_college_application;

public class News_Database_inserted {

     String date;
     String name;
     String description;
     String number;

    public News_Database_inserted( String name, String description, String date, String number)
    {
        this.name= name;
        this.number =number;
        this.date =date;
        this.description = description;
    }

    public  String getName() {
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

    public  String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public  String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
