import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Album> albums= new ArrayList<>();
    public static void main(String[] args) {

        // first album
        Album album= new Album("India Tour Hits", "Arijit Singh");

        album.addSongToAlbum("Kesariya", 4.50, "Arijit Singh & Pritam","Pop");
        album.addSongToAlbum("Deva Deva", 3.45, "Arijit Singh & Pritam", "Pop");

        albums.add(album);

        // Second album
        album= new Album("The Best of 2022", "NCS");

        album.addSongToAlbum("Levitate", 3.03, "Neoni", "Rock");
        album.addSongToAlbum("Redemption", 4.06, "Max Brhon", "Electronic");

        albums.add(album);

        LinkedList<Song> myPlayList= new LinkedList<>();

        albums.get(0).addToPlayList("Deva Deva", myPlayList);
        albums.get(0).addToPlayList("Kesariya", myPlayList);
        albums.get(1).addToPlayList("Redemption", myPlayList);
        albums.get(1).addToPlayList(1, myPlayList);


        play(myPlayList);

    }
    public static void play(LinkedList<Song> playList){
        printMenu();

        ListIterator<Song> songIterator= playList.listIterator();

        //variable to check the position of list iterating pointer (i.e. back/forward of current playing song)
        // first song already playing -> so 1 step ahead
        boolean forward= true;

        if(playList.size() > 0){
            System.out.println("Playing First Song");
            // displaying the first song by overriding toString() method
            System.out.println(songIterator.next().toString());

        }
        else {
            System.out.println("Playlist is Empty");
            return;
        }

        System.out.println("Enter your choice");
        boolean quit= false;
        Scanner sc= new Scanner(System.in);

        while(!quit){

            int choice= sc.nextInt();

            switch(choice){

                case 0: quit= true;
                        System.out.println("Exited from Playlist");
                        break;
                case 1:

                    if(forward==false){
                        songIterator.next();
                        forward= true;
                    }
                    if(songIterator.hasNext()){
                        System.out.println("Playing next "+ songIterator.next().toString());
                        forward= true;
                    }
                    else{
                        System.out.println("End of Playlist");
                        forward= true;
                    }
                    break;
                case 2:

                    if(forward== true){
                        songIterator.previous();
                        forward= false;
                    }
                    if(songIterator.hasPrevious()){
                        System.out.println("Playing previous "+ songIterator.previous().toString());
                        forward= false;
                    }
                    else{
                        System.out.println("Start of Playlist");
                        forward= false;
                    }
                    break;
                case 3:
                    if(forward==true){

                        if(songIterator.hasPrevious()) {
                            System.out.println("Repeating the " + songIterator.previous().toString());
                            forward = false;
                        }
                        else System.out.println("");
                    }
                    else{
                        if(songIterator.hasNext()) {
                            System.out.println("Repeating the " + songIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;
                case 4:
                    System.out.println("All Songs :");
                    printSongs(songIterator);
                    break;
                case 5:

                    if(forward==true){
                        songIterator.remove();
                        System.out.println("Deleted Successfully");
                    }
                    else{
                        songIterator.next();
                        songIterator.remove();
                        System.out.println("Deleted Successfully");
                    }
                    break;

                case 6:
                    printMenu();

//                case 7: // Add song to playlist coming soon...

                default:
                    try{
                        throw new IllegalStateException("Please press the correct option");
                    }
                    catch(IllegalStateException e){
                        System.out.println(e);
                        printMenu();
                    }
            }
        }
    }
    public static void printMenu(){

        System.out.println("Enter your answer :");
        System.out.println("Press 0 : Quit\n" +
                "Press 1 : Play Next Song\n" +
                "Press 2 : Play Previous Song\n" +
                "Press 3 : Repeat the Current Song\n" +
                "Press 4 : Open PlayList\n" +
                "Press 5 : Delete this Song\n" +
                "Press 6 : Display all options");


    }

    public static void printSongs(ListIterator<Song> songListIterator){

        while(songListIterator.hasNext()){
            System.out.println(songListIterator.next().toString()+ " ");
        }
    }
}