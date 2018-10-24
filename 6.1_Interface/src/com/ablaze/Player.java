//DESCRIPTION: A player class that implements from ISaveable interface
//It will implement save and load methods from the interface

package com.ablaze;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable
{
    //************ VARIABLES ************
    private String name;
    private int health_points;
    private int attack_points;
    private String weapon;

    //*********** CONSTRUCTORS **********
    Player()
    {
        this("Player1",100,100);
    }
    Player(String name, int hp, int ap)
    {
        this.name = name;
        this.health_points = hp;
        this.attack_points = ap;
        weapon = "Barehand";
    }

    //************* METHODS *************
    @Override
    public String toString()
    {
        return name+"-"+Integer.toString(health_points)+"-"+
                Integer.toString(attack_points)+"-"+weapon;
    }

    @Override
    public List<String> save()
    {
        //saves all the object fields into a list and returns it
        List<String> my_list = new ArrayList<String>();
        my_list.add(this.name);
        my_list.add(Integer.toString(health_points));
        my_list.add(Integer.toString(attack_points));
        my_list.add(weapon);
        return my_list;
    }

    @Override
    public boolean load(List<String> arr)
    {
        if(arr.size()>0)
        {
            this.name = arr.get(0);
            this.health_points = Integer.parseInt(arr.get(1));
            this.attack_points = Integer.parseInt(arr.get(2));
            this.weapon = arr.get(3);
            return true;
        }
        return false;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return name;
    }
    public void set_name(String name)
    {
        this.name = name;
    }

    public int get_health_points()
    {
        return health_points;
    }
    public void set_health_points(int health_points)
    {
        this.health_points = health_points;
    }

    public int get_attack_points()
    {
        return attack_points;
    }
    public void set_attack_points(int attack_points)
    {
        this.attack_points = attack_points;
    }

    public String get_weapon()
    {
        return weapon;
    }
    public void set_weapon(String weapon)
    {
        this.weapon = weapon;
    }
}
