package com.ablaze;
import java.util.List;

public interface ISaveable
{
    //a method to save class object data into a list
    List<String> save();
    //a method to load values into an object
    boolean load(List<String> arr);
}
