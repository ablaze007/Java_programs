//DESCRIPTION: This is a base class
/*
    The basic hamburger should have the following items.
    Bread roll type, meat and up to 4 additional additions
    (things like lettuce, tomato, carrot, etc) that
    he customer can select to be added to the burger.
    Each one of these items gets charged an additional price
    so you need some way to track how many items got added
    and to calculate the final price (base burger with all
    the additions). This burger has a base price and the
    additions are all separately priced (up to 4 additions,
    see above).
 */

package com.ablaze;

public class Hamburger
{
    //************ VARIABLES ************
    private int bread_roll_type;    //values from 1-3
    private int meat_type;          //values from 1-2
    protected int additional_count;   //values from 0-4
    private double price = 0;

    //*********** CONSTRUCTORS **********
    public Hamburger()
    {
        //generic hamburger
        this(1,1,0);
    }
    public Hamburger(int bread_roll_type, int meat_type, int additional_count)
    {
        this.bread_roll_type = bread_roll_type;
        this.meat_type = meat_type;
        this.additional_count = additional_count;
    }

    //************* METHODS *************
    private void calculate_price()
    {
        this.price += (double)bread_roll_type*0.5;
        this.price += (double)meat_type;
        this.price += (double)additional_count*0.2;
    }
    public void add_additional(int x)
    {
        int new_count = x+this.additional_count;
        if(new_count>=0 && new_count <5)
            this.additional_count += x;
    }
    protected void add_extra_price(double price)
    {
        this.price += price;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public int get_bread_roll_type()
    {
        return bread_roll_type;
    }

    public void set_bread_roll_type(int bread_roll_type)
    {
        if(bread_roll_type >0 && bread_roll_type <4)
            this.bread_roll_type = bread_roll_type;
    }

    public int get_meat_type()
    {
        return meat_type;
    }

    public void set_meat_type(int meat_type)
    {
        if(meat_type>0 && meat_type <4)
            this.meat_type = meat_type;
    }

    public int get_additional_count()
    {
        return additional_count;
    }

    public void set_additional_count(int additional_count)
    {
        if(additional_count<5 && additional_count>=0)
            this.additional_count = additional_count;
    }

    public double get_price()
    {
        this.calculate_price();
        return price;
    }
}
