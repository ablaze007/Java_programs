
package com.ablaze;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        //add several location
        addLocations();

        //movement
        int loc = 1;
        while(true)
        {
            System.out.println(locations.get(loc).getDescription());
            if(loc==0)
                break;

            //print all exits for the location
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits:");
            for(String exit: exits.keySet())
            {
                System.out.print(exit+" ");
            }
            System.out.println();

            //get direction from the user and update loc to its id
            loc = getLocation(exits);
        }
    }

    //gets a phrase from user string and returns a location
    //according to the string if possible
    private static int getLocation(Map<String,Integer> exits)
    {
        String userInput = myScanner.nextLine();
        userInput = userInput.toUpperCase();

        if(exits.containsKey(userInput))
            return exits.get(userInput);

        Map<String, String> directions = new HashMap<>();
        directions.put("NORTH","N");
        directions.put("SOUTH","S");
        directions.put("EAST","E");
        directions.put("WEST","W");
        directions.put("QUIT","Q");

        String[] tokens = userInput.split(" ");
        for(String s: tokens)
        {
            if(directions.containsKey(s))
            {
                if(exits.containsKey(directions.get(s)))
                  return exits.get(directions.get(s));
            }
        }
        System.out.println("Invalid Input, Please try again:");
        return getLocation(exits);
    }

    private static void addLocations()
    {
        //Used regex replace option to convert these
        //these changes were made to make the Location class immutable
//        locations.get(1).addExit("N",5);
//        locations.get(1).addExit("W",2);
//        locations.get(1).addExit("S",4);
//        locations.get(1).addExit("E",3);
//
//        locations.get(2).addExit("N",5);
//
//        locations.get(3).addExit("W", 1);
//
//        locations.get(4).addExit("N",1);
//        locations.get(4).addExit("W",2);
//
//        locations.get(5).addExit("S",1);
//        locations.get(5).addExit("W",2);

        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));

        tempExits.put("N",5);
        tempExits.put("W",2);
        tempExits.put("S",4);
        tempExits.put("E",3);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N",5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N",1);
        tempExits.put("W",2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S",1);
        tempExits.put("W",2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));
    }
}
