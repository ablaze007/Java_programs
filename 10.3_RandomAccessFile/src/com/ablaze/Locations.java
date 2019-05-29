//DESCRIPTION: 
//Implement a class to encapsulate the locations from main class
//so that data can be loaded from external source and prevent
//any changes to the locations from main

//implement Map<> on the class and override all the required methods
//make a static block with codes for initialization

//Save and Load the data using random access

package com.ablaze;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location>
{
    //************ VARIABLES ************
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<Integer, Index> indices = new LinkedHashMap<>();

    private static final String locationsDataFileName = "locations_big.txt";
    private static final String directionsDataFileName = "directions_big.txt";
    private static final String dataFileName = "data.dat";

    private static RandomAccessFile ra;

    //File structure
    //1. First 4 bytes 0-3: number of locations
    //2. Next 4 bytes 4-7: start offset of the locations section
    //3. Next section: index (141 locations * 12 bytes = 1692 bytes) Byte 8-1699
    //4. Final section: location records, starts at byte 1700
    //Each index record contains - location ID, offset for the location, and location length
    //Use a class for index and hold its instances in a map with locationID as a keys

    public static void main(String[] args)
    {
        loadUsingFileReader();
        save();
    }
    static{
        init();
    }

    //save the data using random access
    private static void save()
    {
        try(RandomAccessFile raf = new RandomAccessFile(dataFileName,"rwd"))
        {
            raf.writeInt(locations.size());
            int indexSize = Integer.BYTES * 3 * locations.size();
            int startLocation = Integer.BYTES + indexSize + (int)raf.getFilePointer();
            raf.writeInt(startLocation);

            int indexLocation = (int) raf.getFilePointer();
            raf.seek(startLocation);

            for(Location location : locations.values())
            {
                raf.writeInt(location.getId());
                raf.writeUTF(location.getDescription());

                StringBuilder builder = new StringBuilder();
                for(String key : location.getExits().keySet())
                {
                    if(!key.equalsIgnoreCase("Q"))
                    {
                        builder.append(key);
                        builder.append(",");
                        builder.append(location.getExits().get(key));
                        builder.append(",");
                    }
                }
                raf.writeUTF(builder.toString());

                Index index = new Index(startLocation, (int) (raf.getFilePointer()-startLocation));
                indices.put(location.getId(), index);
                startLocation = (int)raf.getFilePointer();
            }

            raf.seek(indexLocation);
            for(Integer index : indices.keySet())
            {
                raf.writeInt(index);
                raf.writeInt(indices.get(index).getStartLocation());
                raf.writeInt(indices.get(index).getLength());
            }
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    //Initializes indices - reads the index information
    private static void init()
    {
        try
        {
            ra = new RandomAccessFile(dataFileName, "rwd");
            int size = ra.readInt();
            int startLocation = ra.readInt();
            while(ra.getFilePointer() < startLocation)
            {
                int id = ra.readInt();
                int start = ra.readInt();
                int length = ra.readInt();
                Index index = new Index(start, length);
                indices.put(id, index);
            }
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    //To get location (load data) on demand
    //we don't use try-catch here as we need to return a valid Location object
    public Location getLocation(int id) throws IOException
    {
        Index index = indices.get(id);
        ra.seek(index.getStartLocation());
        id = ra.readInt();
        String description = ra.readUTF();
        Location location = new Location(id, description, null);

        if(id!=0)
        {
            String[] data = ra.readUTF().split(",");
            for(int i=0; i<data.length; i++)
            {
                String key = data[i++];
                int value = Integer.parseInt(data[i]);
                location.addExit(key, value);
            }
        }

        return location;
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
