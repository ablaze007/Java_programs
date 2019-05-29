//DESCRIPTION: 

package com.ablaze;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFile extends SimpleFileVisitor<Path>
{
    //************ VARIABLES ************
    private Path src;
    private Path dest;

    //*********** CONSTRUCTORS **********
    CopyFile(Path src, Path dest)
    {
        this.src = src;
        this.dest = dest;
    }

    //************* METHODS *************
    private Path getNewPath(Path path)
    {
        return dest.resolve(src.relativize(path));
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        Files.copy(dir, getNewPath(dir));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        Files.copy(file, getNewPath(file));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
    {
        System.out.println("Error copying: "+file);
        return FileVisitResult.SKIP_SUBTREE;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~

}
