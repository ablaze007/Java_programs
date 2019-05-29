//PROJECT DESCRIPTION
//Read and write some data to the text file
//using java.nio explicitly

// Using java.NIO
// create a binary file
// read and write the following sequentially
// "Hello, world!" 22 100 "Goodbye" 27
// read  the following using random access
// numbers only

package com.ablaze;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    private static final String dataFileName = "data.txt";
    private static final String binaryFileName = "data.dat";
    //stores the local of the number (acts as a index)
    private static final Map<Integer, Integer> locations = new LinkedHashMap<>();

    public static void main(String[] args) {
        writeB();
//        readB();
        readNumber();
    }

    //random read - binary file
    private static void readNumber()
    {
        try(FileInputStream in = new FileInputStream(binaryFileName);
            FileChannel channel = in.getChannel())
        {
            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);

            for (Integer loc : locations.values())
            {
                channel.position(loc);
                channel.read(buffer);
                buffer.flip();
                System.out.println(buffer.getInt(0));
            }

        }catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    //sequential read - binary file
    private static void readB()
    {
        try(FileInputStream in = new FileInputStream(binaryFileName);
            FileChannel channel = in.getChannel())
        {
            ByteBuffer tempBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.read(tempBuffer);
            tempBuffer.flip();
            int size = tempBuffer.getInt();

            ByteBuffer buffer = ByteBuffer.allocate(size);
            channel.read(buffer);
            buffer.flip();

            int size1 = buffer.getInt();
            byte[] bytes = new byte[size1];
            buffer.get(bytes);
            System.out.println(new String(bytes));

            System.out.println(buffer.getInt());

            System.out.println(buffer.getInt());

            size1 = buffer.getInt();
            bytes = new byte[size1];
            buffer.get(bytes);
            System.out.println(new String(bytes));

            System.out.println(buffer.getInt());

        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    //sequential write - binary file
    private static void writeB()
    {
        //create a channel
        try(FileOutputStream out = new FileOutputStream(binaryFileName);
            FileChannel channel = out.getChannel())
        {
            String string1 = "Hello, world!";
            int int1 = 22;
            int int2 = 100;
            String string2 = "Goodbye!";
            int int3 = 27;

            int totalBytes = string1.getBytes().length + string2.getBytes().length + 5*Integer.BYTES;
            //3 integer numbers, 3 integer sizes to store two string length

            //create a buffer
            ByteBuffer buffer = ByteBuffer.allocate(totalBytes+Integer.BYTES);

            //WRITING TO THE BUFFER --------------------------------------->
            //write the total size of buffer
            buffer.putInt(totalBytes);

            //write the data
            buffer.putInt(string1.length()).put(string1.getBytes());
            locations.put(int1, buffer.position());
            buffer.putInt(int1);
            locations.put(int2, buffer.position());
            buffer.putInt(int2).putInt(string2.length()).put(string2.getBytes());
            locations.put(int3, buffer.position());
            buffer.putInt(int3);

            //reset buffer position
            buffer.flip();

            //write from buffer to the channel
            channel.write(buffer);
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    //text file
    public static void write(String data)
    {
        try{
            Path path = FileSystems.getDefault().getPath(dataFileName);
            Files.write(path, ("\n"+data).getBytes("UTF-8"), StandardOpenOption.APPEND);
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    //text file
    public static void read()
    {
        try{
            Path path = FileSystems.getDefault().getPath(dataFileName);
            List<String> lines = Files.readAllLines(path);
            for(String line : lines)
                System.out.println(line);
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }
}
