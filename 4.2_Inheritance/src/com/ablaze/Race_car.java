package com.ablaze;

public class Race_car extends Vehicle
{
    //********VARIABLES*******
    private String model;
    private int top_gear; //CAN BE ANY VALUE FROM 1 - 10

    //*******CONSTRUCTORS******
    Race_car(String model, int top_gear)
    {
        super("Race_car");
        this.model = model;
        this.top_gear = top_gear;
    }
    Race_car()
    {
        this("Unknown",2);
    }

    //**** METHODS ***********
    @Override
    public boolean set_gear(int gear)
    {
        if(gear>0 && gear<top_gear+1)
        {
            super.set_gear(gear);
            return true;
        }
        return false;
    }

    // GETTERS AND SETTERS

    public String get_model()
    {
        return model;
    }
    public int get_top_gear()
    {
        return top_gear;
    }

    public void set_top_gear(int top_gear)
    {
        this.top_gear = top_gear;
    }
    public void set_model(String model)
    {
        this.model = model;
    }

}

