//DESCRIPTION: 

package com.ablaze;

public class Healthy_burger extends Hamburger
{
    //************ VARIABLES ************

    //*********** CONSTRUCTORS **********
    public Healthy_burger()
    {
        //generic Healthy_burger
        this(1,0);
    }
    public Healthy_burger(int meat_type, int additional_count)
    {
        super(3,meat_type,additional_count);
    }
    //************* METHODS *************
    @Override
    public void add_additional(int x)
    {
        int new_count = x+this.additional_count;
        if(new_count>=0 && new_count <=6)
            super.additional_count += x;
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    @Override
    public void set_additional_count(int x)
    {
        if(x>=0 && x<=6)
            super.additional_count = x;
    }
}
