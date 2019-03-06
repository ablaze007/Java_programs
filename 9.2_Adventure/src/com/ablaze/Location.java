//DESCRIPTION: 

package com.ablaze;
import java.util.Map;
import java.util.HashMap;

//Immutable class
public final class Location
{
    //************ VARIABLES ************
    private final int id;
    private final String description;
    private final Map<String, Integer> exits;

    //*********** CONSTRUCTORS **********
    Location(int id, String description, Map<String, Integer> exits)
    {
        this.id = id;
        this.description = description;
        //new HashMap is instantiated inorder to
        //prevent changes made to parameter
        //exits to change the instance variable exits
        if(exits == null)
            this.exits = new HashMap<>();
        else
            this.exits = new HashMap<>(exits);
        this.exits.put("Q",0);
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
