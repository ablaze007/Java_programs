//DESCRIPTION:
// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

package com.ablaze;

public class Main
{
    private static League<Football_team> PL;

    public static void main(String[] args)
    {
        initialization();
        PL.print_table();
        //The following code will cause an error since League generic class
        //has upper bound as Football_team. This can be even more generalized
        //by setting Team class as upper bound and extending Football_team class
        //from Team class
        //League<String> MLS = new League<>();
    }

    //a method to initialize variables needed
    public static void initialization()
    {
        PL = new League<>("Premier League");
        Football_team City = new Football_team("Man City");
        Football_team United = new Football_team("Man United");
        Football_team Chelsea = new Football_team("Chelsea");
        Football_team Liverpool = new Football_team("Liverpool");
        PL.add_team(City);
        PL.add_team(United);
        PL.add_team(Liverpool);
        PL.add_team(Chelsea);
        //Following code will not work since PL is an object of generic class League
        //that has been set to accept type of Football_team only
        //PL.add_team("Spurs");

        //All match results are written here
        System.out.println("~~~ Results ~~~");
        City.match_result(United,4,0);
        City.match_result(Liverpool,3,1);
        United.match_result(Chelsea, 1,3);
        Chelsea.match_result(Liverpool,2,2);
        System.out.println("");
    }
}
