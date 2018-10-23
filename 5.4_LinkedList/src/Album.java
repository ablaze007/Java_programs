//DESCRIPTION: An album class that hold an array list of songs

import java.util.ArrayList;
import java.util.Iterator;

public class Album
{
    //************ VARIABLES ************
    private ArrayList<Song> songs;
    private String Album_name;

    //*********** CONSTRUCTORS **********
    Album(String name, ArrayList<Song> songs)
    {
        this.songs = new ArrayList<Song>(songs);
        this.Album_name = name;
    }
    Album(String name, Song song)
    {
        this(name);
        songs.add(song);
    }
    Album(String name)
    {
        this.Album_name = name;
        songs = new ArrayList<Song>();
    }

    //************* METHODS *************
    public boolean add_song(Song song)
    {
        Iterator<Song> it = songs.iterator();
        if(it.hasNext())
        {
            if(it.next().get_name().equals(song.get_name()))
                return false;
        }
        songs.add(song);
        return true;
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public ArrayList<Song> get_songs()
    {
        return this.songs;
    }
    public String get_album_name()
    {
        return this.Album_name;
    }
}
