package com.ms.mongowheels.beans;

public class Identification
{

    private String Classification;
    private String ID;
    private String Make;
    private String modelYear;
    private int Year;

    public String getClassification()
    {
        return Classification;
    }

    public void setClassification(String classification)
    {
        Classification = classification;
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
        return Make;
    }

    public void setMake(String make)
    {
        Make = make;
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
        return Year;
    }

    public void setYear(int year)
    {
        Year = year;
    }

}