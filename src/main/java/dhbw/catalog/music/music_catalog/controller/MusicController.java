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

    private MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAllTracks(@RequestParam(required = false) String title) {

        try {

            List<Track> tracks = new ArrayList<Track>();

            if (title == null) {
                tracks.addAll(musicRepository.findAll());
            } else {
                tracks.addAll(musicRepository.findByTitleContaining(title));
            }

            if (tracks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tracks, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable("id") long id) {

        Optional<Track> trackData = musicRepository.findById(id);

        if (trackData.isPresent()) {
            return new ResponseEntity<>(trackData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/posts")
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
