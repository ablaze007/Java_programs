//OBJECTIVE: To demonstrate the implementation of Interface
/*
MAIN - creates a player object pokemon, saves it, and loads new data into it
 */
package com.ablaze;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
	    ISaveable pokemon = new Player("Pikachu",150,200);
        System.out.println(pokemon.toString());
        save_object(pokemon);
        load_object(pokemon);
        System.out.println(pokemon.toString());
        System.out.println("Exiting...");
    }

    //a method that calls save method from ISaveable object
    //Assumption - we assume that we save it to our local drive
    //and print the saving statement
    private static void save_object(ISaveable obj)
    {
        if(obj == null)
            return;
        for(int i=0; i<obj.save().size(); i++)
            System.out.println("Saving - " + obj.save().get(i));
    }

    //a method that loads data into ISaveable object
    private static void load_object(ISaveable obj)
    {
        if(obj == null)
            return;
        List<String> new_list = readValues();
        if(obj.load(new_list))
            System.out.println("Loading successful!");
        else
            System.out.println("Error: Can not load data!");
    }

    //a method that read user input and returns it as an array list
    private static ArrayList<String> readValues()
    {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Choose\n" +
                "1 - Enter pokemon data\n" +
                "0 - Quit");
        System.out.print(">> ");
        if(!scanner.hasNextInt())
        {
            scanner.nextLine();
            return readValues();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==1)
        {
            System.out.println("Enter pokemon name: ");
            values.add(scanner.nextLine());
            System.out.println("Enter HP: ");
            values.add(Integer.toString(scanner.nextInt()));
            scanner.nextLine();
            //assuming user input will be an int
            System.out.println("Enter AP: ");
            values.add(Integer.toString(scanner.nextInt()));
            scanner.nextLine();
            System.out.println("Select weapon: ");
            values.add(scanner.nextLine());
        }
        return values;
    }
}
