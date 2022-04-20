package com.ms.mongowheels.beans;

public class EngineStats
{
    private int horsepower;
    private int torque;

    public EngineStats()
    {
        horsepower = 0;
        torque = 0;
    }

    public int getHorsepower()
    {
        return horsepower;
    }

    public void setHorsepower(int horsepower)
    {
        this.horsepower = horsepower;
    }

    public int getTorque()
    {
        return torque;
    }

    public void setTorque(int torque)
    {
        this.torque = torque;
    }


}