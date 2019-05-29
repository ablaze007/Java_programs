//DESCRIPTION: 

package com.ablaze;

public class Index
{
    //************ VARIABLES ************
    private final int startLocation;
    private final int length;

    //*********** CONSTRUCTORS **********
    Index(int startLocation, int length)
    {
        this.startLocation = startLocation;
        this.length = length;
    }
    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~

    public int getStartLocation()
    {
        return startLocation;
    }

    public int getLength()
    {
        return length;
    }
}
