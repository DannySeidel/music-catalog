package dhbw.catalog.music.music_catalog.repository;

import dhbw.catalog.music.music_catalog.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Track, Long> {

    List<Track> findByTitle(String title);

    List<Track> findByArtist(String artist);

    List<Track> findByGenre(String genre);

    List<Track> findByReleaseYear(Integer releaseYear);

    List<Track> findByMedium(String medium);

    List<Track> findByFilename(String filename);
}
