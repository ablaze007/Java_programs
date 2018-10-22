package com.ablaze;

public class Ferrari extends Race_car
{
    //****** VARIABLES ***********
    private String license;
    //******* CONSTRUCTORS ***********
    Ferrari(String license)
    {
        super("Ferrar",5);
        this.license = license;
    }
    //******* METHODS ************

    // GETTERS AND SETTERS
    public String get_license()
    {
        return license;
    }
    public void set_license(String license)
    {
        this.license = license;
    }
}
