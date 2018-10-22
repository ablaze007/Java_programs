//OBJECTIVE: to illustrate composition
//          to create a manager class drawing tools
//          which will include other classes as its state

package com.ablaze;

public class Main
{
    public static void main(String[] args)
    {
        //creating new object of manager class
	    Drawing_tools box = new Drawing_tools(new Crayon(),new Eraser());

	    //two ways to access methods of component objects from manager object
	    box.get_crayon().draw("line");
        box.erase("line"); //this is usually the better way

	    box.get_crayon().set_current_color("Red");
	    box.get_crayon().draw("circle");

    }
}
