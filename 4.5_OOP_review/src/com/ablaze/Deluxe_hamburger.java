//DESCRIPTION: 

package com.ablaze;

public class Deluxe_hamburger extends Hamburger
{
    //************ VARIABLES ************

    //*********** CONSTRUCTORS **********
    public Deluxe_hamburger()
    {
        this(1,1);
    }
    public Deluxe_hamburger(int bread_roll_type, int meat_type)
    {
        super(bread_roll_type,meat_type,0);
    }
    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    @Override
    public double get_price()
    {
        super.add_extra_price(0.5);
        return super.get_price();
    }
}
