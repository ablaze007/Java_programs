//DESCRIPTION: 

package com.ablaze;

public class Football_team implements Comparable<Football_team>
{
    //************ VARIABLES ************
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int loss;

    //*********** CONSTRUCTORS **********
    Football_team(String name)
    {
        this.name = name;
        points = 0;
        wins = 0;
        draws = 0;
        loss = 0;
    }
    //************* METHODS *************
    @Override
    public int compareTo(Football_team t)
    {
        if(this.points > t.points)
            return -1;
        else if(this.points < t.points)
            return 1;
        return 0;
    }

    //a method that accounts for match results and adjust points
    public void match_result(Football_team opponent, int score, int score_opp)
    {
        if(score>score_opp)
        {
            this.points+=3;
            wins++;
        }
        else if(score<score_opp)
        {
            loss++;
        }
        else
        {
            this.points+=1;
            draws++;
        }
        if(opponent!=null)
        {
            System.out.println(this.name + " "+score+":"+score_opp+" "+opponent.get_name());
            opponent.match_result(null, score_opp, score);
        }
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return name;
    }
    public int get_points()
    {
        return points;
    }
    public int get_wins()
    {
        return wins;
    }
    public int get_draws()
    {
        return draws;
    }
    public int get_loss()
    {
        return loss;
    }
}
