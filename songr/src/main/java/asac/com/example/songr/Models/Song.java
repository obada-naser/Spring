package asac.com.example.songr.Models;



import javax.persistence.*;

@Entity
public class Song {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id", nullable = false)
     private int id;
     private String title;
     private double length;
     private int trackNumber;
     @ManyToOne
     private Album album;

     public Song(){

     }

     public Song(String title, double length, int trackNumber) {
          this.title = title;
          this.length = length;
          this.trackNumber = trackNumber;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public double getLength() {
          return length;
     }

     public void setLength(double length) {
          this.length = length;
     }

     public int getTrackNumber() {
          return trackNumber;
     }

     public void setTrackNumber(int trackNumber) {
          this.trackNumber = trackNumber;
     }

     public Album getAlbum() {
          return album;
     }

     public void setAlbum(Album album) {
          this.album = album;
     }

     @Override
     public String toString() {
          return "Song{" +
                  "title='" + title + '\'' +
                  ", length=" + length +
                  ", trackNumber=" + trackNumber +
                  ", album=" + album +
                  '}';
     }
}
