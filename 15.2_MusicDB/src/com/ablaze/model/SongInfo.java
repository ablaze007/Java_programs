//DESCRIPTION: 

package com.ablaze.model;

public class SongInfo {
    //************ VARIABLES ************
    private String name;
    private String album;
    private String artist;
    private int track;

    //*********** CONSTRUCTORS **********
    public SongInfo(String name, String album, String artist, int track) {
        this.name = name;
        this.album = album;
        this.track = track;
        this.artist = artist;
    }

    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public int getTrack() {
        return track;
    }

    public String getArtist() {
        return artist;
    }
}
