//DESCRIPTION: A song class that has name and length as attribute

public class Song
{
    //************ VARIABLES ************
    private String name;
    private int length;     //in seconds

    //*********** CONSTRUCTORS **********

    public Song(String name, int length)
    {
        this.name = name;
        this.length = length;
    }

    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return name;
    }
    public void set_name(String name)
    {
        this.name = name;
    }

    public int get_length()
    {
        return length;
    }
    public void set_length(int length)
    {
        this.length = length;
    }
}
