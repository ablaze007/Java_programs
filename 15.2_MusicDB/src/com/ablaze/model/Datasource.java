//DESCRIPTION:
/*
 * This class is used to connect and manipulate the database music.db
 *
 * Implement the following methods:
 * open, close  - opens/closes the db connection
 * define enum sortOrder for ascending, descending, and none
 * List<Artist> queryArtists(int sortOrder) - returns list of artist
 * List<String> queryAlbumsForArtist(String artistName, int sortOrder) - returns list of albums for a given artist
 * List<SongsInfo> querySongsForArtist(String artistName, int sortOrder)
 * List<SongsInfo> queryArtistForSong(String songName) - Use wildcard to match songName
 * int getCount(int table) - use enum for tables
 * boolean insertSong(String title, String album, String artist, int track) -   use transaction
 *      assume the song title is unique, implement other methods required for this method
 *
 * Use constant fields to minimize hard-coding
 * Use column indices to address the table columns
 *
 * Create the following classes based on the music.db database schema:
 * artist, songInfo
 * Create a view to join all three tables and use it whenever possible
 * Use prepared statements wherever required
 */

package com.ablaze.model;

import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

    private Connection conn;
    private static final Datasource instance = new Datasource();
    private Statement statement;

    private static final String DB_NAME = "music.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:"
            + Paths.get(".").toAbsolutePath().resolve(DB_NAME).normalize();
    private static final String SONGS_INFO_VIEW = "songsInfoView";

    public enum SortOrder {
        ASC,
        DESC,
        NO_ORDER
    }

    public enum Tables {
        artists,
        songs,
        albums
    }

    //******************* QUERIES ****************
    private final String albumsForArtistQuery = "SELECT a.name as name"+
            " FROM albums as a" + " INNER JOIN artists as r" +
            " ON a.artist = r._id" + " WHERE r.name = ?";

    private final String albumsForArtistQueryAsc = albumsForArtistQuery +
            " ORDER BY name ASC";

    private final String albumsForArtistQueryDesc = albumsForArtistQuery +
            " ORDER BY name DESC";

    private final String songsInfoViewQuery = "CREATE VIEW "+ SONGS_INFO_VIEW+ " AS" +
            " SELECT s.track as track, s.title as song, a.name as album, r.name as artist" +
            " FROM songs as s" +
            " INNER JOIN albums as a ON s.album = a._id" +
            " INNER JOIN artists as r ON a.artist = r._id";

    private final String songsForArtistQuery = "SELECT album, track, song, artist" +
            " FROM "+SONGS_INFO_VIEW+" WHERE artist = ? ORDER BY album, track, song";

    private final String artistsForSongQuery = "SELECT album, track, song, artist FROM "+SONGS_INFO_VIEW+
            " WHERE song LIKE ?";

    private final String getArtistIDQuery = "SELECT _id FROM artists " +
            " WHERE name = ?";

    private final String getAlbumIDQuery = "SELECT _id FROM albums " +
            " WHERE name = ? AND artist = ? ";

    private final String insertArtistQuery = "INSERT INTO artists(name) values(?)";
    private final String insertAlbumQuery = "INSERT INTO albums(name, artist) values(?, ?)";
    private final String insertSongQuery = "INSERT INTO songs(track, title, album) " +
            "values(?, ?, ?)";

    //************* PREPARED STATEMENTS ****************
    private PreparedStatement albumsForArtistPrepared;
    private PreparedStatement albumsForArtistPreparedAsc;
    private PreparedStatement albumsForArtistPreparedDesc;
    private PreparedStatement songsForArtistPrepared;
    private PreparedStatement artistsForSongPrepared;
    private PreparedStatement getArtistIDPrepared;
    private PreparedStatement getAlbumIDPrepared;
    private PreparedStatement insertArtistPrepared;
    private PreparedStatement insertAlbumPrepared;
    private PreparedStatement insertSongPrepared;

    private Datasource() {
        //empty private constructor
    }

    public static Datasource getInstance() {
        return instance;
    }

    public void open() {
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            try {
                statement = conn.createStatement();
                createView();
                albumsForArtistPrepared = conn.prepareStatement(albumsForArtistQuery);
                albumsForArtistPreparedAsc = conn.prepareStatement(albumsForArtistQueryAsc);
                albumsForArtistPreparedDesc = conn.prepareStatement(albumsForArtistQueryDesc);
                songsForArtistPrepared = conn.prepareStatement(songsForArtistQuery);
                artistsForSongPrepared = conn.prepareStatement(artistsForSongQuery);
                getArtistIDPrepared = conn.prepareStatement(getArtistIDQuery);
                getAlbumIDPrepared = conn.prepareStatement(getAlbumIDQuery);
                insertArtistPrepared = conn.prepareStatement(insertArtistQuery, Statement.RETURN_GENERATED_KEYS);
                insertAlbumPrepared = conn.prepareStatement(insertAlbumQuery);
                insertSongPrepared = conn.prepareStatement(insertSongQuery);
            } catch (SQLException e) {
                throw new SQLException("Error creating/preparing statements");
            }
        } catch(SQLException s) {
            System.out.println(s.getMessage());
            try {
                if(statement!=null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch(SQLException sql) {

            }
        }
    }

    public void close() {
        try {
            if(insertAlbumPrepared!=null)
                insertAlbumPrepared.close();
            if(insertArtistPrepared!=null)
                insertArtistPrepared.close();
            if(artistsForSongPrepared!=null)
                artistsForSongPrepared.close();
            if(songsForArtistPrepared!=null)
                songsForArtistPrepared.close();
            if(albumsForArtistPreparedDesc!=null)
                albumsForArtistPreparedDesc.close();
            if(albumsForArtistPreparedAsc!=null)
                albumsForArtistPreparedAsc.close();
            if(albumsForArtistPrepared!=null)
                albumsForArtistPrepared.close();
            dropView();
            if(statement!=null)
                statement.close();
            if(conn!=null)
                conn.close();
        } catch(SQLException e) {
            System.out.println("Error closing the connection!");
        }
    }

    public void createView() {
        try{
            statement.execute(songsInfoViewQuery);
        } catch(SQLException e) {
            System.out.println("Could not create view!");
        }
    }

    public void dropView() {
        try{
            statement.execute("DROP VIEW "+SONGS_INFO_VIEW);
        } catch(SQLException e) {
            System.out.println("Could not delete view!");
        }
    }

    public List<Artist> queryArtists() {
        return queryArtists(SortOrder.NO_ORDER);
    }

    public List<Artist> queryArtists(SortOrder order) {
        try{
            StringBuilder query = new StringBuilder("SELECT name FROM artists ");
            if(order != SortOrder.NO_ORDER) {
                query.append("ORDER BY name ");
                query.append(order.toString());
            }

            ResultSet results = statement.executeQuery(query.toString());
            List<Artist> result = new ArrayList<>();
            while(results.next()) {
                result.add(new Artist(results.getString(1)));
            }
            return result;
        } catch(SQLException e) {
            System.out.println("Could not query Artists");
            e.printStackTrace();
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName) {
        return queryAlbumsForArtist(artistName, SortOrder.NO_ORDER);
    }
    public List<String> queryAlbumsForArtist(String artistName, SortOrder order) {
        if(albumsForArtistPrepared == null) {
            return null;
        }
        PreparedStatement p;
        if(order == SortOrder.NO_ORDER)
            p = albumsForArtistPrepared;
        else if(order == SortOrder.ASC)
            p = albumsForArtistPreparedAsc;
        else
            p = albumsForArtistPreparedDesc;

        try {
            p.setString(1, artistName);
            ResultSet results = p.executeQuery();
            List<String> result = new ArrayList<>();
            while( results.next() ){
                result.add(results.getString(1));
            }
            return result;

        } catch( SQLException e ){
            System.out.println("Query failed");
            return null;
        }
    }

    public List<SongInfo> querySongsForArtist(String artistName) {
        if(songsForArtistPrepared == null)
            return null;

        try{
            songsForArtistPrepared.setString(1,artistName);
            ResultSet results = songsForArtistPrepared.executeQuery();
            List<SongInfo> result = new ArrayList<>();
            while(results.next()) {
                String album = results.getString(1);
                String name = results.getString(3);
                String artist = results.getString(4);
                int track = results.getInt(2);
                result.add(new SongInfo(name, album, artist, track));
            }

            return result;
        } catch(SQLException e) {
            System.out.println("Could not query songs for artist!");
            return null;
        }
    }

    public List<SongInfo> queryArtistsForSong(String songName) {
        try{
            artistsForSongPrepared.setString(1, "%"+songName+"%");
            ResultSet results = artistsForSongPrepared.executeQuery();
            List<SongInfo> result = new ArrayList<>();
            while(results.next()) {
                String album = results.getString(1);
                int track = results.getInt(2);
                String song = results.getString(3);
                String artist = results.getString(4);
                result.add(new SongInfo(song, album, artist, track));
            }
            return result;
        } catch(SQLException e) {
            System.out.println("Could not query for artist!");
            return null;
        }
    }

    public int getCount(Tables table) {
        try{
            ResultSet result = statement.executeQuery("SELECT count(*) FROM "+table.toString());
            if(result.next()) {
                return result.getInt(1);
            } else
                throw new SQLException("No data retrieved");
        } catch(SQLException s){
            System.out.println("Could not execute query");
            return -1;
        }
    }

    public boolean insertSong(String title, String album, String artist, int track) {
        //check and get artist id
        //check and get album id
        //insert into the songs table
        try{
            conn.setAutoCommit(false);
            int artistId = getArtistID(artist);
            int albumId = getAlbumId(album, artistId);

            insertSongPrepared.setInt(1, track);
            insertSongPrepared.setString(2, title);
            insertSongPrepared.setInt(3, albumId);
            insertSongPrepared.execute();

            conn.commit();
            return true;
        }catch(SQLException s) {
            try{
                conn.rollback();
            } catch(SQLException e) {
                System.out.println("Could not roll back!");
            }
            System.out.println("Could not insert song - "+s.getMessage());
            return false;
        }finally {
            try {
                conn.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Can not set auto commit to true - "+e.getMessage());
            }
        }
    }

    private int getArtistID(String artistName) throws SQLException {
        getArtistIDPrepared.setString(1, artistName);
        ResultSet result = getArtistIDPrepared.executeQuery();
        if(result.next()) {
            return result.getInt(1);
        } else {
            //insert the artist
            insertArtistPrepared.setString(1,artistName);
            insertArtistPrepared.execute();
            result = insertArtistPrepared.getGeneratedKeys();
            if(result.next())
                return result.getInt(1);
            else
                throw new SQLException("Could not insert artist");
        }
    }

    private int getAlbumId(String albumName, int artistId) throws SQLException {
        getAlbumIDPrepared.setString(1, albumName);
        getAlbumIDPrepared.setInt(2, artistId);
        ResultSet result = getAlbumIDPrepared.executeQuery();
        if(result.next()) {
            return result.getInt(1);
        } else {
            //insert the artist
            insertAlbumPrepared.setString(1,albumName);
            insertAlbumPrepared.setInt(2, artistId);
            insertAlbumPrepared.execute();
            result = insertAlbumPrepared.getGeneratedKeys();
            if(result.next())
                return result.getInt(1);
            else
                throw new SQLException("Could not insert album");
        }
    }

}
