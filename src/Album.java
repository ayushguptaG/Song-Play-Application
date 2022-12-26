import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Album {

     private String name;
     private String artistName;
     private ArrayList<Song> songs;

     public Album(String name, String artistName){
         this.name= name;
         this.artistName= artistName;
         this.songs= new ArrayList<>();
     }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean findSong(String titleName){

         // searching the song by title in arraylist
         for(Song s : songs){
             if(s.getTitle().equals(titleName))
                 return true;
         }
         return false;
     }

     // adding song to playlist when provided with name
     public void addToPlayList(String title, LinkedList<Song> playList){

         // if input song exists then add...
             for (Song s : songs) {
                 if (s.getTitle().equals(title)) {
                     playList.add(s);
                     return;
                 }
             }
     }

     // adding song to playlist when provided with track number
     public void addToPlayList(int trackNo, LinkedList<Song> playList){

         // convert track number to index value
         int index= trackNo-1;

         //search in album(arrayList) with this index and add it.
         if(index >=0 && index<songs.size()){
             playList.add(songs.get(index));
         }
     }

     //adding song/new song to album(arraylist)
     public void addSongToAlbum(String title, double duration, String artistName, String genre){

         //if song already exists..dont add
         if(findSong(title)==true)
             System.out.println("Song already exists.");
         else
         {
             Song s1= new Song(title, duration, artistName, genre);
             songs.add(s1);
             System.out.println("Song added successfully!");
         }

     }


}
