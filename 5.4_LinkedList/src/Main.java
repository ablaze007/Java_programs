//DESCRIPTION: To implement LinkedList and iterator
/*
    A program that implements a song playlist. Different songs from
    different available albums can be added to the playlist and then
    played, rewind, and more.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit; //for sleep method

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Song> playlist = new LinkedList<>();
    private static ArrayList<Album> album_list = new ArrayList<>();

    public static void main(String[] args)
    {
        //Creating some default albums and adding songs to them
        initialize_albums();

        //display menu to add songs from albums
        display_album_menu();

        //playing songs from playlist
        ListIterator<Song> it = playlist.listIterator();
        if(it.hasNext())
        {
            System.out.println("--------------------");
            System.out.println("Playing - "+it.next().get_name());
            sleep(2);
        }
        //display playlist menu
        int choice = display_playlist_menu();

        while(choice!=5)
        {
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Playing - " + it.previous().get_name());
                    sleep(2);
                    it.next();  //resetting the cursor in the playlist in forward direction
                }break;

                case 2:
                {
                    if(it.hasNext())
                        System.out.println("Playing - " + it.next().get_name());
                    else
                        System.out.println("- End of playlist -");
                    sleep(2);
                }break;

                case 3:
                {
                    it.previous();
                    if (it.hasPrevious())
                        System.out.println("Playing - " + it.previous().get_name());
                    else
                        System.out.println("- Beginning of playlist -");
                    sleep(2);
                    it.next();
                }break;

                case 4:
                {
                    Iterator<Song> temp_it = playlist.iterator();
                    System.out.println("--- Songs in Playlist ---");
                    while (temp_it.hasNext())
                    {
                        System.out.println(temp_it.next().get_name());
                    }
                    System.out.println("-------------------------");
                    sleep(1);
                }break;

                default:
                    break;
            }
            choice = display_playlist_menu();
        }
        System.out.println("Exiting...");
    }

    private static int display_playlist_menu()
    {
        System.out.println("----- Playlist ------");
        System.out.println("1. Replay");
        System.out.println("2. >> ");
        System.out.println("3. << ");
        System.out.println("4. Show playlist");
        System.out.println("5. Exit");
        System.out.println("---------------------");
        if(!scanner.hasNextInt())
        {
            scanner.nextLine();
            display_playlist_menu();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    //a method to display list of all albums available and a menu
    private static void display_album_menu()
    {
        System.out.println("------- ALBUMS --------");
        Iterator<Album> it = album_list.iterator();
        int count = 0;
        while (it.hasNext())
        {
            count++;
            System.out.println(count + " " + it.next().get_album_name());
        }
        if (count == 0)
        {
            System.out.println("No Album found!");
            return;
        }
        System.out.println("-----------------------");
        System.out.println("1.Explore an album");
        System.out.println("2.Play playlist");
        while(!scanner.hasNextInt())
        {
            scanner.nextLine();
            System.out.println("Invalid input! Choose an option again...");
            System.out.println(">> ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==1)
        {
            System.out.println("Enter album name: ");
            String name = scanner.nextLine();
            list_songs_in_album(name);
        }
    }

    //a method to list all songs in an album
    private static void list_songs_in_album(String name)
    {
        Album curr_album = null;
        ListIterator<Album> it = album_list.listIterator();
        int check = 0;
        while(it.hasNext())
        {
            if(it.next().get_album_name().equals(name))
            {
                curr_album = it.previous();
                System.out.println("----- SONGS -----");
                for(Song song : curr_album.get_songs())
                    System.out.println(song.get_name());
                it.next();
                check++;
            }
        }
        if(check==0)
        {
            System.out.println("Album not found!");
            sleep(1);
            display_album_menu();
            return;
        }
        System.out.println("-----------------");
        System.out.println("1. Add a song");
        System.out.println("2. Done");

        while(!scanner.hasNextInt())
        {
            scanner.nextLine();
            System.out.println("Invalid input! Try again...");
            System.out.println(">> ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1)
        {
            System.out.println("Enter song name: ");
            String song_name = scanner.nextLine();
            Iterator<Song> it2 = curr_album.get_songs().iterator();
            check = 0;
            while(it2.hasNext())
            {
                Song curr_song = it2.next();
                if(curr_song.get_name().equals(song_name))
                {
                    playlist.add(curr_song);
                    System.out.println("** ADDED!! **");
                    sleep(1);
                    check = 1;
                    break;
                }
            }
            if(check==0)
            {
                System.out.println(song_name+" does not exist!");
                sleep(1);
            }
            list_songs_in_album(name);
            return;
        }
        display_album_menu();
    }

    //a method to initialize albums
    private static void initialize_albums()
    {
        Album album1 = new Album("Bruno Mars");
        Album album2 = new Album("Maroon5");

        album1.add_song(new Song("Finesse",180));
        album1.add_song(new Song("Grenade",200));
        album1.add_song(new Song("Uptown Funk",160));

        album2.add_song(new Song("Sugar",210));
        album2.add_song(new Song("Girl like you",180));
        album2.add_song(new Song("Animal",150));

        album_list.add(album1);
        album_list.add(album2);
    }

    //a method to sleep system for n seconds
    private static void sleep(int seconds)
    {
        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){};
    }
}
