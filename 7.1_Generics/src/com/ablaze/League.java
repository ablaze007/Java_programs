//DESCRIPTION: A generic league class that stores league table
//for teams of that particular sport only

package com.ablaze;
import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Football_team>
{
    //************ VARIABLES ************
    private ArrayList<T> teams;
    private String name;

    //*********** CONSTRUCTORS **********
    League(String name)
    {
        this.name = name;
        teams = new ArrayList<>();
    }
    //************* METHODS *************
    public void add_team(T team)
    {
        if(teams.contains(team))
        {
            System.out.println(team.get_name()+" already added");
        }
        else
            teams.add(team);
    }

    public void print_table()
    {
        Collections.sort(teams);
        System.out.println("*** "+this.name+" ***");
        System.out.println("Position - Team name - Points");
        int pos = 1;
        for (T team : teams)
        {
            System.out.println(pos+" - "+team.get_name()+" - "+team.get_points());
            pos++;
        }
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return name;
    }
}
