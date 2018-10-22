package com.ablaze;

public class Drawing_tools
{
    //********** VARIABLES **********
    private Crayon crayon;
    private Eraser eraser;

    //********** CONSTRUCTOR **********
    Drawing_tools(Crayon crayon, Eraser eraser)
    {
        this.crayon = crayon;
        this.eraser = eraser;
    }

    //********* METHODS *************
    public void erase(String object)
    {
        eraser.erase(object);
    }

    // ~~~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public Crayon get_crayon()
    {
        return this.crayon;
    }
}
