package com.ablaze;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Theatre myTheatre = new Theatre("YOLO",20);

        if(myTheatre.reserveSeat("A1"))
            System.out.println("Reserved");
        else
            System.out.println("Unavailable");
        myTheatre.printSeats();
        if(myTheatre.reserveSeat("A1"))
            System.out.println("Reserved");
        else
            System.out.println("Unavailable");
    }
}
