package com.example.music_catalog.repository;

import com.example.music_catalog.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query("SELECT s FROM Track s WHERE s.filename = ?1")
    Optional<Track> findTrackByFilename(String filename);

    List<Track> findByTitleContaining(String title);

    List<Track> findByArtistContaining(String artist);

    List<Track> findByGenreContaining(String genre);

    List<Track> findByReleaseYearContaining(Integer releaseYear);

    List<Track> findByMediumContaining(String medium);
}
