package com.example.music_catalog.model;

import javax.persistence.*;

@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "srtist")
    private String artist;
    @Column(name = "genre")
    private String genre;
    @Column(name = "releaseYear")
    private Integer releaseYear;
    @Column(name = "filename")
    private String filename;
    @Column(name = "medium")
    private String medium;

    public Track() {
    }

    public Track(long id,
                 String title,
                 String artist,
                 String genre,
                 Integer releaseYear,
                 String filename,
                 String medium) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.filename = filename;
        this.medium = medium;
    }

    public Track(String title,
                 String artist,
                 String genre,
                 Integer releaseYear,
                 String filename,
                 String medium) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", filename='" + filename + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
