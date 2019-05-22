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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Locations implements Map<Integer, Location>
{
    //************ VARIABLES ************
    private static Map<Integer, Location> locations = new HashMap<>();
    private static final String locationsDataFileName = "locations_big.txt";
    private static final String directionsDataFileName = "directions_big.txt";

    //static initializer
    static {
//        load();
//        saveUsingByteStream();
        loadUsingByteStream();
    }

//    public static void main(String[] args)
//    {
//        //save();
//    }

    //************* METHODS *************
    //method to create the files
    private static void save()
    {
//        try(FileWriter writer = new FileWriter(locationsDataFileName);
//            FileWriter writer2 = new FileWriter(directionsDataFileName)
//        )
//        {
//            for(Location location : locations.values())
//            {
//                writer.write(location.getId()+","+location.getDescription()+"\n");
//                for(String exit : location.getExits().keySet())
//                {
//                    writer2.write(location.getId()+","+exit+","+location.getExits().get(exit)+"\n");
//                }
//            }
//        }catch(IOException e)
//        {
//            e.printStackTrace();
//        }

        //Using BufferedWriter
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("test1.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("test2.txt"))
        )
        {
            for(Location location : locations.values())
            {
                writer.write(location.getId()+","+location.getDescription()+"\n");
                for(String exit : location.getExits().keySet())
                {
                    if(!exit.equalsIgnoreCase("Q"))
                        writer2.write(location.getId()+","+exit+","+location.getExits().get(exit)+"\n");
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    //method to load the files
    private static void load()
    {
        //read the locations data
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(locationsDataFileName))))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String description = data[1];
                Map<String, Integer> tempExits = new HashMap<>();
                locations.put(id, new Location(id, description, tempExits));
            }
            System.out.println("Loaded - "+locationsDataFileName);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        //read the exits data
        //without using scanner
        try(BufferedReader reader = new BufferedReader(new FileReader(directionsDataFileName)))
        {
            String input;
            while((input = reader.readLine()) != null)
            {
                String[] data = input.split(",");
                int id = Integer.parseInt(data[0]);
                String exit = data[1];
                int exitId = Integer.parseInt(data[2]);
                Location location = locations.get(id);
                location.addExit(exit, exitId);
            }
            System.out.println("Loaded - "+ directionsDataFileName +"\n");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void saveUsingByteStream()
    {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bat"))))
        {
            for(Location location : locations.values())
            {
                //printing to ensure correct write (Replace later with printing to log file)
                System.out.println("Writing - "+location.getId()+" "+location.getDescription());
                out.writeInt(location.getId());
                out.writeUTF(location.getDescription());
                System.out.println("Writing - "+location.getExits().size()+" exits");
                out.writeInt(location.getExits().size());
                for(String key : location.getExits().keySet())
                {
                    if(!key.equalsIgnoreCase("Q")){
                        out.writeUTF(key);
                        out.writeInt(location.getExits().get(key));
                    }
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void loadUsingByteStream()
    {
        try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bat"))))
        {
            boolean eof = false;
            while(!eof)
            {
                try{
                    int id = in.readInt();
                    String description = in.readUTF();
                    Map<String, Integer> tempExit = new HashMap<>();
                    int size = in.readInt();
                    System.out.println("Reading - "+id+" "+description);
                    System.out.println(size+" exits");
                    for(int i=0; i<size; i++)
                    {
                        String exit = in.readUTF();
                        int value = in.readInt();
                        tempExit.put(exit, value);
                    }
                    locations.put(id, new Location(id, description, tempExit));
                }catch(EOFException e)
                {
                    eof = true;
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
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
