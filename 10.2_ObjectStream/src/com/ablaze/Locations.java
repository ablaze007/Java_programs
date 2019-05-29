//DESCRIPTION: 
//Implement a class to encapsulate the locations from main class
//so that data can be loaded from external source and prevent
//any changes to the locations from main

//implement Map<> on the class and override all the required methods
//make a static block with codes for initialization
//store the location (id & description) in a file using FileWriter
//store the exits in another file
//use try-finally first, and then convert to try-with-resources
//then in static block, write the code to read those files and
//read, create & add locations from the file using scanner & FileReader
//read the exits from the file and add them to the locations using scanner & BufferedReader
//write a method in Location class addExit(String, int) that will make adding exit easier
//try using string.split() instead of scanner.delimiter();

//write methods to load and save data using byte stream and a single file

package com.ablaze;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location>
{
    //************ VARIABLES ************
    private static Map<Integer, Location> locations = new HashMap<>();
    private static final String locationsDataFileName = "locations_big.txt";
    private static final String directionsDataFileName = "directions_big.txt";

    static{
        //loadUsingFileReader();
        load("data.dat");
        //save("data.dat");
    }

    private static void save(String filename)
    {
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            for(Location location : locations.values())
            {
                out.writeObject(location);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void load(String filename)
    {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename))))
        {
            boolean eof = false;
            while(!eof)
            {
                try{
                    Location location = (Location) in.readObject();
                    locations.put(location.getId(),location);
                }catch(EOFException e)
                {
                    eof = true;
                }
            }
        }catch(IOException|ClassNotFoundException io)
        {
            io.printStackTrace();
        }
    }

    //to load initial data
    private static void loadUsingFileReader()
    {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(locationsDataFileName)));
            Scanner scanner2 = new Scanner(new BufferedReader(new FileReader(directionsDataFileName)))
        )
        {
            while(scanner.hasNextLine())
            {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String description = data[1];
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(id, new Location(id, description, tempExit));
            }
            while(scanner2.hasNextLine())
            {
                String[] data = scanner2.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String direction = data[1];
                int value = Integer.parseInt(data[2]);
                locations.get(id).addExit(direction,value);
            }
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    @Override
    public int size()
    {
        return locations.size();
    }

    @Override
    public boolean isEmpty()
    {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key)
    {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value)
    {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key)
    {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m)
    {
        //will not use
    }

    @Override
    public void clear()
    {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet()
    {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values()
    {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet()
    {
        return locations.entrySet();
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
}
