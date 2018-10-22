package com.ablaze;

public class Crayon
{
    //******* VARIABLES **********
    private String current_color;

    //********* CONSTRUCTOR ********
    Crayon(String color)
    {
        this.current_color=color;
    }
    Crayon()
    {
        this("Black");
    };

    //********** METHODS *********
    public void draw(String object)
    {
        System.out.println(object +" drawn using "+ current_color.toUpperCase() +" crayon!");
    }

    //~~~~~ GETTERS AND SETTERS *******
    public String get_current_color()
    {
        return current_color;
    }
    public void set_current_color(String current_color)
    {
        if(current_color.toLowerCase().equals("black") ||
                current_color.toLowerCase().equals("blue") ||
                current_color.toLowerCase().equals("red") ||
                current_color.toLowerCase().equals("green"))
            this.current_color = current_color;
    }
}
