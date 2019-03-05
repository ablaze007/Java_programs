//DESCRIPTION: 

package com.ablaze;

import java.util.*;

public class Theatre
{
    //************ VARIABLES ************
    private String theatreName;
    private int totalSeats;
    private List<Seat> seats = new ArrayList<>();

    //*********** CONSTRUCTORS **********
    Theatre(String name, int numSeats)
    {
        this.theatreName = name;
        this.totalSeats = numSeats;

        for(int i=0; i<totalSeats/2; i++)
        {
            Seat newSeat = new Seat("A"+(i+1));
            seats.add(newSeat);
        }
        for(int j=totalSeats/2; j<totalSeats; j++)
        {
            Seat newSeat = new Seat("B"+(j+1));
            seats.add((newSeat));
        }
    }

    //************* METHODS *************
    public boolean reserveSeat(String seat)
    {
        Seat s = new Seat(seat);
        int index = Collections.binarySearch(seats, s, null);
        if(index >= 0)
            return seats.get(index).reserve();
        else
        {
            System.out.println("Invalid seat!");
            return false;
        }
//        for(Seat s: seats)
//        {
//            if(s.getSeatNumber().compareToIgnoreCase(seat)==0)
//            {
//                if(!s.getStatus())
//                {
//                    s.reserve();
//                    System.out.println("Reserved!");
//                }
//                else
//                    System.out.println("Seat unavailable!");
//                return;
//            }
//        }
//        System.out.println("Invalid seat");
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public void printSeats()
    {
        System.out.println("*** "+theatreName+" ***");
        for(Seat s: seats)
            System.out.println(s);
    }
    //Inner class
    private class Seat implements Comparable<Seat>
    {
        private String seatNumber;
        private boolean reserved;

        Seat(String seatNumber)
        {
            this.seatNumber = seatNumber;
            reserved = false;
        }

        private boolean reserve()
        {
            if(reserved)
                return false;
            reserved = true;
            return reserved;
        }

        private boolean getStatus()
        {
            return reserved;
        }

        private String getSeatNumber()
        {
            return seatNumber;
        }

        @Override
        public String toString()
        {
            if(reserved)
                return seatNumber+" - "+"R";
            else
                return seatNumber;
        }

        @Override
        public int compareTo(Seat s)
        {
            return this.getSeatNumber().compareToIgnoreCase(s.getSeatNumber());
        }
    }
}
