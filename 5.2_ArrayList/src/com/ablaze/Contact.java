//DESCRIPTION: 

package com.ablaze;

public class Contact
{
    //************ VARIABLES ************
    private String name;
    private int number;

    //*********** CONSTRUCTORS **********
    public Contact(String name, int number)
    {
        this.name = name;
        if(number>0)
            this.number = number;
        else
            this.number = 0;
    }

    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return name;
    }
    public int get_number()
    {
        return number;
    }
    public void set_name(String name)
    {
        this.name = name;
    }
    public  void set_number(int number)
    {
        if(number>0)
            this.number = number;
        else
            this.number = 0;
    }
}
