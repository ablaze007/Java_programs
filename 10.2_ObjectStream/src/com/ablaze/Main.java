
package com.ablaze;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    private static Locations locations = new Locations();
    private static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args)
    {
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
}
