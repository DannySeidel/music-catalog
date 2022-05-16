package dhbw.catalog.music.music_catalog.model;

import javax.persistence.*;

@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title = null;

    @Column(name = "artist")
    private String artist = null;

    @Column(name = "genre")
    private String genre = null;

    @Column(name = "releaseYear")
    private Integer releaseYear = null;

    @Column(name = "filename")
    private String filename = null;

    @Column(name = "medium")
    private String medium = null;

    public Track() {

    }

    public Track(String title, String artist, String genre, Integer releaseYear, String filename, String medium) {

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.filename = filename;
        this.medium = medium;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void  setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {

        return "Post [id="+ this.id +
                ", title=" + this.title +
                ", artist=" + this.artist +
                ", genre=" + this.genre +
                ", releaseYear=" + this.releaseYear +
                ", filename=" + this.filename +
                ", medium=" + this.medium + "]";
    }
}
