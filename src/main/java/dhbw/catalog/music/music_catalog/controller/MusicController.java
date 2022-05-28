package dhbw.catalog.music.music_catalog.controller;


import dhbw.catalog.music.music_catalog.model.Track;
import dhbw.catalog.music.music_catalog.repository.MusicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class MusicController {

    private final MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAllTracks() {

        try {

            List<Track> tracks = new ArrayList<Track>(musicRepository.findAll());

            if (tracks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tracks, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tracks")
    public ResponseEntity<HttpStatus> deleteAllTracks() {
        try {
            musicRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable("id") long id) {

        Optional<Track> trackData = musicRepository.findById(id);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData.get(), HttpStatus.OK);
    }

    @PutMapping("/track/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable("id") long id, @RequestBody Track track) {

        Optional<Track> trackData = musicRepository.findById(id);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Track currentTrack = trackData.get();

        currentTrack.setTitle(track.getTitle());
        currentTrack.setArtist(track.getArtist());
        currentTrack.setGenre(track.getGenre());
        currentTrack.setReleaseYear(track.getReleaseYear());
        currentTrack.setFilename(track.getFilename());
        currentTrack.setMedium(track.getMedium());

        musicRepository.save(currentTrack);

        return new ResponseEntity<>(currentTrack, HttpStatus.OK);
    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<Track> deleteTrack(@PathVariable("id") long id) {

        Optional<Track> trackData = musicRepository.findById(id);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        musicRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/track/title/{title}")
    public ResponseEntity<List<Track>> getTrackByTitle(@PathVariable("title") String title) {

        List<Track> trackData = musicRepository.findByTitle(title);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @GetMapping("/track/artist/{artist}")
    public ResponseEntity<List<Track>> getTrackByArtist(@PathVariable("artist") String artist) {

        List<Track> trackData = musicRepository.findByArtist(artist);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @GetMapping("/track/genre/{genre}")
    public ResponseEntity<List<Track>> getTrackByGenre(@PathVariable("genre") String genre) {

        List<Track> trackData = musicRepository.findByGenre(genre);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @GetMapping("/track/releaseYear/{releaseYear}")
    public ResponseEntity<List<Track>> getTrackByReleaseYear(@PathVariable("releaseYear") Integer releaseYear) {

        List<Track> trackData = musicRepository.findByReleaseYear(releaseYear);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @GetMapping("/track/filename/{filename}")
    public ResponseEntity<List<Track>> getTrackByFilename(@PathVariable("filename") String filename) {

        List<Track> trackData = musicRepository.findByFilename(filename);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @GetMapping("/track/medium/{medium}")
    public ResponseEntity<List<Track>> getTrackByMedium(@PathVariable("medium") String medium) {

        List<Track> trackData = musicRepository.findByMedium(medium);

        if (trackData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trackData, HttpStatus.OK);
    }

    @PostMapping("/track")
    public ResponseEntity<Track> createTrack(@RequestBody Track track) {

        try {

            Track _track = musicRepository
                    .save(new Track(
                            track.getTitle(),
                            track.getArtist(),
                            track.getGenre(),
                            track.getReleaseYear(),
                            track.getFilename(),
                            track.getMedium()
                    ));

            return new ResponseEntity<>(_track, HttpStatus.CREATED);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
