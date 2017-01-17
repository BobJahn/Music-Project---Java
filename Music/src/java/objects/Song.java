package objects;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


//Song class. The entity stored in the various MySQL tables.
@Entity
@Table(name = "music.biglist")
@NamedQuery (name="Song.findAll", query = "SELECT i FROM Song i")
public class Song implements Serializable{
    
    @Id// the following data field is our primary key
    private String name = "All Along the Watchtower";
    private String artist = "Jimi Hendrix";
    private double rating = 0;
    private Date releaseDate = new Date(1968, 10, 22);
    
    
    public Song() {}
    
    public Song(String name, String artist, Date releaseDate, double rating) {
        this.name = name;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

   
    
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
