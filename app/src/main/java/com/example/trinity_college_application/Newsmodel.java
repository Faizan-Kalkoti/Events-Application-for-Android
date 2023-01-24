package com.example.trinity_college_application;

public class Newsmodel {

    private String date, description, name, number;

    public Newsmodel()
    {

    }

   public Newsmodel(String date, String description, String name, String number) {
        this.date = date;
        this.description = description;
        this.name = name;
        this.number = number;
    }


    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }



}

