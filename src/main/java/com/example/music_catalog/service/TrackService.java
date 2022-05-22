package com.example.music_catalog.service;

import com.example.music_catalog.model.Track;
import com.example.music_catalog.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getTracks() {
        return trackRepository.findAll();

    }

    public List<Track> getTracksByTitle(String title) {

        List<Track> tracks = new ArrayList<Track>();

        if (title == null) {
            tracks.addAll(trackRepository.findAll());
        } else {
            tracks.addAll(trackRepository.findByTitleContaining(title));
        }

        return tracks;
    }

    public List<Track> getTracksByArtist(String artist) {

        List<Track> tracks = new ArrayList<Track>();

        if (artist == null) {
            tracks.addAll(trackRepository.findAll());
        } else {
            tracks.addAll(trackRepository.findByArtistContaining(artist));
        }

        return tracks;
    }

    public List<Track> getTracksByGenre(String genre) {

        List<Track> tracks = new ArrayList<Track>();

        if (genre == null) {
            tracks.addAll(trackRepository.findAll());
        } else {
            tracks.addAll(trackRepository.findByGenreContaining(genre));
        }

        return tracks;
    }

    public List<Track> getTracksByReleaseYear(Integer releaseYear) {

        List<Track> tracks = new ArrayList<Track>();

        if (releaseYear == null) {
            tracks.addAll(trackRepository.findAll());
        } else {
            tracks.addAll(trackRepository.findByReleaseYearContaining(releaseYear));
        }

        return tracks;
    }

    public List<Track> getTracksByMedium(String medium) {

        List<Track> tracks = new ArrayList<Track>();

        if (medium == null) {
            tracks.addAll(trackRepository.findAll());
        } else {
            tracks.addAll(trackRepository.findByMediumContaining(medium));
        }

        return tracks;
    }

    public void addNewTrack(Track track) {
        Optional<Track> trackOptional = trackRepository.findTrackByFilename(track.getFilename());
        if(trackOptional.isPresent()) {
            throw new IllegalStateException("Filename already exists");
        }
        trackRepository.save(track);
    }

    public void deleteStudent(Long trackId) {
        boolean exists = trackRepository.existsById(trackId);
        if(!exists) {
            throw new IllegalStateException("track with id " + trackId + " does not exist");
        }
        trackRepository.deleteById(trackId);
    }

    @Transactional
    public void updateTrack(Long trackId, String title, String artist, String genre, Integer releaseYear, String filename, String medium) {
        Track track = trackRepository.findById(trackId).orElseThrow(() -> new IllegalStateException("track with id " + trackId + "does not exist"));

        if(title != null && title.length()>0 && !Objects.equals(track.getTitle(), title)) {
            track.setTitle(title);
        }

        if(artist != null && artist.length()>0 && !Objects.equals(track.getArtist(), artist)) {
            track.setArtist(artist);
        }

        if(genre != null && genre.length()>0 && !Objects.equals(track.getGenre(), genre)) {
            track.setGenre(genre);
        }

        if(releaseYear != null && releaseYear>0 && !Objects.equals(track.getReleaseYear(), releaseYear)) {
            track.setReleaseYear(releaseYear);
        }

        if(filename != null && filename.length()>0 && !Objects.equals(track.getFilename(), filename)) {
            Optional<Track> trackOptional = trackRepository.findTrackByFilename(filename);
            if(trackOptional.isPresent()) {
                throw new IllegalStateException("filename does already exist");
            }
            track.setFilename(filename);
        }

        if(medium != null && medium.length()>0 && !Objects.equals(track.getMedium(), medium)) {
            track.setMedium(medium);
        }

    }
}