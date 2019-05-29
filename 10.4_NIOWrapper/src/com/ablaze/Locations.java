//DESCRIPTION: 
//Implement a class to encapsulate the locations from main class
//so that data can be loaded from external source and prevent
//any changes to the locations from main

//Change the save and load methods in 10.1 and 10.2 to wrap java.NIO
//In other words, implement saving and loading data using
//BufferedWriter/Reader and ObjectInput/OutputStream wrapped in java.NIO

package com.ablaze;

import jdk.jshell.execution.LoaderDelegate;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location>
{
    //************ VARIABLES ************
    private static Map<Integer, Location> locations = new HashMap<>();
    private static final String locationsDataFileName = "locations_big.txt";
    private static final String directionsDataFileName = "directions_big.txt";
    private static final String dataFileName = "data.dat";

    public static void main(String[] args)
    {
        save();
    }

    static{
        //loadUsingFileReader();
        load();
    }

    private static void save()
    {
        //using ObjectOutputStream with java.NIO
        Path path = FileSystems.getDefault().getPath(dataFileName);
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path))))
        {
            for(Location location : locations.values())
                out.writeObject(location);
        }catch(IOException io)
        {
            io.printStackTrace();
        }

        //using BufferWriter
//        Path path = FileSystems.getDefault().getPath(locationsDataFileName);
//        Path path2 = FileSystems.getDefault().getPath(directionsDataFileName);
//
//        try(BufferedWriter writer = Files.newBufferedWriter(path);
//            BufferedWriter writer2 = Files.newBufferedWriter(path2))
//        {
//            for(Location location : locations.values())
//            {
//                writer.write(location.getId()+"");
//                writer.write(",");
//                writer.write(location.getDescription());
//                writer.write("\n");
//
//                for(String key : location.getExits().keySet())
//                {
//                    if(!key.equalsIgnoreCase("Q"))
//                    {
//                        writer2.write(location.getId()+","+key+","+location.getExits().get(key)+"\n");
//                    }
//                }
//            }
//        }catch (IOException io)
//        {
//            io.printStackTrace();
//        }
    }

    private static void load()
    {
        //using ObjectInputStream with java.NIO
        Path path = FileSystems.getDefault().getPath(dataFileName);
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path))))
        {
            boolean eof = false;
            while(!eof)
            {
                try{
                    Location location = (Location) in.readObject();
                    locations.put(location.getId(), location);
                }catch(EOFException t)
                {
                    eof=true;
                }
            }
        }catch(IOException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }

//        //using BufferReader
//        Path path = FileSystems.getDefault().getPath(locationsDataFileName);
//        Path path2 = FileSystems.getDefault().getPath(directionsDataFileName);
//
//        try(BufferedReader reader = Files.newBufferedReader(path);
//            BufferedReader reader2 = Files.newBufferedReader(path2))
//        {
//            String line;
//            while( (line = reader.readLine()) != null)
//            {
//                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0]);
//                String description = data[1];
//                Location location = new Location(id, description, null);
//                locations.put(id, location);
//            }
//            while( (line = reader2.readLine()) != null)
//            {
//                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0]);
//                String key = data[1];
//                int value = Integer.parseInt(data[2]);
//                locations.get(id).addExit(key, value);
//            }
//        }catch(IOException io)
//        {
//            io.printStackTrace();
//        }
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
