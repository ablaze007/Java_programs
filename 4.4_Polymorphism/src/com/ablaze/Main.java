//OBJECTIVE: To demonstrate Polymorphism using method over-riding

//It is better to include all the classes in the main java file when the
//classes are short and small

package com.ablaze;

// A parent class
class Country           //we DO NOT USE access modifier for the class present in main file
{
    private String name;

    public Country(String name)
    {
        this.name = name;
    }

    public String population()
    {
        return "Unknown";
    }

    public String get_name()
    {
        return name;
    }
}

// THREE CHILD Classes
class Nepal extends Country
{
    public Nepal()
    {
        super("Nepal");
    }

    @Override
    public String population()
    {
        return "29m";
    }
}

class USA extends Country
{
    public USA()
    {
        super("USA");
    }

    @Override
    public String population()
    {
        return "326m";
    }
}

class India extends Country
{
    public India()
    {
        super("India");
    }

    //No population function here
}

public class Main {

    public static void main(String[] args) {
        //we create 6 random objects of child classes of Country
        //and test their Over-ridden methods
        for(int i=0; i<6; i++)
        {
            Country c = randomCountry();
            System.out.println("Country: "+c.get_name());
            System.out.println("Population: "+c.population());
            System.out.println();
        }
    }

    private static Country randomCountry()
    {
        int random_num = (int) (Math.random()*3+1);
        //Here random function generates pseudo-random numbers (double) between 0 and 1
        //Since we need random numbers between 1 and 3, we multiply it by 3 and add 1
        //then we cast the double value to int

        switch(random_num)
        {
            //return respective Country object
            case 1:
                return new Nepal();
            case 2:
                return new USA();
            case 3:
                return new India();
        }
        return null;
    }
}
