package com.ms.mongowheels.beans;

public class Engine
{
    private String Driveline;
    private String engineType;
    private boolean Hybrid;
    private int numGears;
    private String Transmission;
    private EngineStats engineStats;

    public String getDriveline()
    {
        return Driveline;
    }

    public void setDriveline(String driveline)
    {
        Driveline = driveline;
    }

    public String getEngineType()
    {
        return engineType;
    }

    public void setEngineType(String engineType)
    {
        this.engineType = engineType;
    }

    public boolean isHybrid()
    {
        return Hybrid;
    }

    public void setHybrid(boolean hybrid)
    {
        Hybrid = hybrid;
    }

    public int getNumGears()
    {
        return numGears;
    }

    public void setNumGears(int numGears)
    {
        this.numGears = numGears;
    }

    public String getTransmission()
    {
        return Transmission;
    }

    public void setTransmission(String transmission)
    {
        Transmission = transmission;
    }
}
