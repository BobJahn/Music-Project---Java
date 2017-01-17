package objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//SongList class. Responsible for storing all songs.
public class SongList {
    private ArrayList<Song> songs = new ArrayList<Song>();
        
    
    public SongList() {}
    
    public SongList(List<Song> list) {
        for(int i = 0; i < list.size(); i++) {
            songs.add(list.get(i));
        }
    }
    
    
    public void add(Song w1) {
        songs.add(w1);
    }
    
    
    public ArrayList getSongs() {
        return songs;
    }
    
    public ArrayList getSongs(String artist) {
        ArrayList temp = new ArrayList();
        for (Song song : songs) {
            if(song.getArtist().equals(artist)) {
                temp.add(song);
            }
        }
        songs = temp;
        return songs;
    }
    
    public int getAmount() {
        return songs.size();
    }
    
    
    public void sortByName() {
        Collections.sort(songs, (Song s1, Song s2) -> s1.getName().compareToIgnoreCase(s2.getName()));  
    }
    
    public void sortByArtist() {
        Collections.sort(songs, (Song s1, Song s2) -> s1.getArtist().compareToIgnoreCase(s2.getArtist()));
    }
    
    public void sortByDate() {
        Collections.sort(songs, (Song s1, Song s2) -> s1.getReleaseDate().compareTo(s2.getReleaseDate()));
    }
    
    public void sortByRating() {
        Collections.sort(songs, (Song s1, Song s2) -> {
            double rating = s1.getRating()-s2.getRating();
            if(rating < 0) {
                return 1;
            }
            else if(rating > 0) {
                return -1;
            }
            else {
                return 0;   
            }
        });
    }
}
