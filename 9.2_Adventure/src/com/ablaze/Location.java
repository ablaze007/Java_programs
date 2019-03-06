//DESCRIPTION: 

package com.ablaze;
import java.util.Map;
import java.util.HashMap;

//TODO: Make location class final
public class Location
{
    //************ VARIABLES ************
    private final int id;
    private final String description;
    private final Map<String, Integer> exits;

    //*********** CONSTRUCTORS **********
    Location(int id, String description)
    {
        this.id = id;
        this.description = description;
        exits = new HashMap<>();
        exits.put("Q",0);
    }

    //************* METHODS *************
    public void addExit(String direction, int location)
    {
        exits.put(direction, location);
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public int getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public Map<String, Integer> getExits()
    {
        //to prevent any external modification to the HashMap
        return new HashMap<>(exits);
    }
}
