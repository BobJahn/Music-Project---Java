package connector;


import java.sql.Date;
import java.util.List;
import objects.Song;
import javax.persistence.*;
import objects.SongList;

//  MusicDB class. Responsible for interacting with the associated MySQL server.
public class MusicDB {
    
    //Add a song to the default bigList table.
    public static String addSong(String name, String artist, Date release, double rating) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Song s = em.find(Song.class, name);
        if(s != null) {
            return "Song Already Exists!";
        }
        s = new Song(name, artist, release, rating);
        em.getTransaction().begin();
        em.persist(s); 
        em.getTransaction().commit();
        em.close();
        return "Song " + name + " added!";
    }
    
    //Return all songs from the bigList table.
    
    public static SongList getAllSongs() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Song> list = em.createNamedQuery("Song.findAll", Song.class).getResultList();
        return new SongList(list);
    }
    
    //Delete a song from the bigList table.
    public static String deleteSong(String name) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Song s = em.find(Song.class, name);
        if(s == null) {
            return "Nothing to delete! Song not found!";
        }
 
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        
        return "Song " + s.getName() + " has been removed!";
    }
}
