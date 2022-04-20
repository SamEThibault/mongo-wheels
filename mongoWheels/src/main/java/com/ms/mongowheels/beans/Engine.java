package com.ms.mongowheels.beans;

public class Engine
{
    private String driveline;
    private String engineType;
    private boolean hybrid;
    private int numGears;
    private String transmission;
    private EngineStats engineStats;

    // no argument constructor
    public Engine()
    {
        driveline = "default";
        engineType = "default";
        hybrid = false;
        numGears = 0;
        transmission = "default";
        engineStats = new EngineStats();
    }

    public String getDriveline()
    {
        return driveline;
    }

    public void setDriveline(String driveline)
    {
        this.driveline = driveline;
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
        return hybrid;
    }

    public void setHybrid(boolean hybrid)
    {
        this.hybrid = hybrid;
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
        return transmission;
    }

    public void setTransmission(String transmission)
    {
        this.transmission = transmission;
    }
}
