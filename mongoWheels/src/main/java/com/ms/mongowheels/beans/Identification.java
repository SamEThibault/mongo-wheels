package com.ms.mongowheels.beans;

public class Identification
{

    private String classification;
    private String ID;
    private String make;
    private String modelYear;
    private int year;

    public Identification()
    {
        classification = "default";
        ID = "default";
        make = "default";
        modelYear = "default";
        year = 0;
    }

    public Identification(String classificationIn, String IDIn, String makeIn, String modelYearIn,
                          int yearIn)
    {
        classification = classificationIn;
        ID = IDIn;
        make = makeIn;
        modelYear = modelYearIn;
        year = yearIn;
    }

    public String getClassification()
    {
        return classification;
    }

    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModelYear()
    {
        return modelYear;
    }

    public void setModelYear(String modelYear)
    {
        this.modelYear = modelYear;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

}