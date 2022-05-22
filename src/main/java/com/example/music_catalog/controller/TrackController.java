package com.example.music_catalog.controller;

import com.example.music_catalog.model.Track;
import com.example.music_catalog.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getTracks() {


        return trackService.getTracks();
    }

    @GetMapping(path = "title/{trackTitle}")
    public List<Track> getTracksByTitle(@PathVariable("trackTitle") String trackTitle) {


        return trackService.getTracksByTitle(trackTitle);
    }

    @GetMapping(path = "artist/{trackArtist}")
    public List<Track> getTracksByArtist(@PathVariable("trackArtist") String trackArtist) {


        return trackService.getTracksByArtist(trackArtist);
    }

    @GetMapping(path = "genre/{trackGenre}")
    public List<Track> getTracksByGenre(@PathVariable("trackGenre") String trackGenre) {


        return trackService.getTracksByGenre(trackGenre);
    }

    @GetMapping(path = "release/{trackReleaseYear}")
    public List<Track> getTracksByReleaseYear(@PathVariable("trackReleaseYear") Integer trackReleaseYear) {


        return trackService.getTracksByReleaseYear(trackReleaseYear);
    }

    @GetMapping(path = "medium/{trackMedium}")
    public List<Track> getTracksByMedium(@PathVariable("trackMedium") String trackMedium) {


        return trackService.getTracksByMedium(trackMedium);
    }

    @PostMapping
    public void registerNewTrack(@RequestBody Track track) {

        trackService.addNewTrack(track);
    }

    @DeleteMapping(path = "{trackId}")
    public void deleteTrack(@PathVariable("trackId") Long trackId) {
        trackService.deleteStudent(trackId);
    }

    @PutMapping(path = "{trackId}")
    public void updateTrack(
            @PathVariable("trackId") Long trackId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) String filename,
            @RequestParam(required = false) String medium
    ) {
        trackService.updateTrack(trackId, title, artist, genre, releaseYear, filename, medium);
    }
}
