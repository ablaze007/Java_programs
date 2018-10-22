package com.ablaze;

public class Vehicle
{
    //******* VARIABLES *********
    private String vehicle_type;
    private int gear;
    private double distance_covered;
    private double fuel_level;

    //****** CONSTRUCTORS ******
    Vehicle(String vehicle_type)
    {
        this.vehicle_type = vehicle_type;
        this.gear = 1;
        this.distance_covered = 0;
        this.fuel_level = 100;
    }
    Vehicle()
    {
        this("Unknown");
    }

    //******* METHODS ***********
    public boolean move(double distance)
    {
        if(fuel_level < distance*gear)
            return false;
        fuel_level -= distance*gear;
        distance_covered += distance;
        return true;
    }

    public void refuel()
    {
        this.fuel_level = 100;
    }

    // GETTERS AND SETTERS
    public String get_vehicle_type()
    {
        return vehicle_type;
    }
    public int get_gear()
    {
        return gear;
    }
    public double get_distance_covered()
    {
        return distance_covered;
    }
    public double get_fuel_level()
    {
        return fuel_level;
    }

    public void set_distance_covered(double distance_covered)
    {
        this.distance_covered = distance_covered;
    }
    public void set_fuel_level(double fuel_level)
    {
        this.fuel_level = fuel_level;
    }
    public void set_vehicle_type(String vehicle_type)
    {
        this.vehicle_type = vehicle_type;
    }
    public boolean set_gear(int gear)
    {
        this.gear = gear;
        return true;
    }

}
