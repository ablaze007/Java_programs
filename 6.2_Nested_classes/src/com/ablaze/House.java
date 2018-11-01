//DESCRIPTION: 

package com.ablaze;
import java.util.ArrayList;

//OUTER CLASS
public class House
{
    //************ VARIABLES ************
    private String owner_name;
    private String color;
    private int levels;
    private Doors doors;

    //*********** CONSTRUCTORS **********
    House(String owner_name, String color, int levels)
    {
        this.owner_name = owner_name;
        this.color = color;
        this.levels = levels;
        doors = new Doors();
    }

    //************* METHODS *************
    // TYPE - INNER CLASS
    public class Room
    {
        private String type;
        Room(String type)
        {
            this.type = type;
        }
        //Methods
        public String get_type()
        {
            return type;
        }
        public void set_type(String type)
        {
            this.type = type;
        }
    }
    // TYPE - INNER CLASS
    private class Doors
    {
        private int count;
        Doors()
        {
            count = 1;
        }
        //Methods
        private int get_count()
        {
            return count;
        }
        private void add_door()
        {
            count++;
        }
    }
    public int get_doors_count()
    {
        return doors.get_count();
    }
    public void add_door()
    {
        doors.add_door();
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_owner_name()
    {
        return owner_name;
    }
    public void set_owner_name(String owner_name)
    {
        this.owner_name = owner_name;
    }

    public String get_color()
    {
        return color;
    }
    public void set_color(String color)
    {
        this.color = color;
    }

    public int get_levels()
    {
        return levels;
    }
    public void set_levels(int levels)
    {
        this.levels = levels;
    }
}
