/*
 * DESCRIPTION:
 * Implement classes in model package
 * The database-related code are separated so that the main
 * can run even if the data source is changed later
 */

package com.ablaze;

import com.ablaze.model.Datasource;
import com.ablaze.model.SongInfo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Datasource datasource;

    public static void main(String[] args) {
        datasource = Datasource.getInstance();

        datasource.open();

//        List<Artist> artists = datasource.queryArtists();
//        for(Artist a : artists) {
//            System.out.println(a.getName());
//        }

//        for(String s : datasource.queryAlbumsForArtist("AC DC")) {
//            System.out.println(s);
//        }

//        List<SongInfo> songs = new ArrayList<>(datasource.querySongsForArtist("AC DC"));
//        for(SongInfo s : songs) {
//            System.out.println(s.getAlbum()+": "+s.getTrack()+" - "+s.getName());
//        }

//        System.out.println(datasource.insertSong("Highway to the Hell","Hell","AC DC", 1));

//        for(SongInfo s : datasource.queryArtistsForSong("life"))
//            System.out.println(s.getArtist()+" - "+s.getName());

//        System.out.println(datasource.getCount(Datasource.Tables.artists));



        datasource.close();
    }
}
