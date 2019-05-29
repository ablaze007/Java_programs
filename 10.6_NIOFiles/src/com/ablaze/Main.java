//Using java.nio.file.Files
//practice the following
//creating files and directories
//copy, move, rename, replace, and delete files
//get file attributes

//print the contents of dir1 using DirectoryStream<Path>
//print all file & dir names in dir1 using WalkFileTree(Path, FileVisitor)
//copy all the contents in dir1 directory to dir2 directory using WalkFileTree
//search for file2.txt in dir1 directory

package com.ablaze;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main
{

    public static void main(String[] args)
    {
        Path path = FileSystems.getDefault().getPath("dir1");
//        listContents(Paths.get(".","dir1"));
//        listAllContents(FileSystems.getDefault().getPath("dir1"));
//        copyAll(Paths.get(".","dir1"), Paths.get(".","dir2","dir2Copy"));
        searchAll(path, "file1.txt");
    }

    private static void listContents(Path path)
    {
        try
        {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            for (Path p : paths)
                System.out.println(p);
        } catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    private static void listAllContents(Path path)
    {
        try
        {
            Files.walkFileTree(path, new SimpleFileVisitor<>()
            {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    System.out.println(dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
                {
                    System.out.println(file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    private static void copyAll(Path source, Path destination)
    {
        try
        {
            Files.walkFileTree(source, new CopyFile(source, destination));
        } catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    private static void searchAll(Path path, String name)
    {
        try{
            Files.walkFileTree(path, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    if(dir.getFileName().toString().equals(name))
                    {
                        System.out.println("Found - "+dir.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
                {
                    if(file.getFileName().toString().equals(name))
                    {
                        System.out.println("Found - "+file.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
