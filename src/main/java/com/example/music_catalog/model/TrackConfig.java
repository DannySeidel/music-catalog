/*package com.example.music_catalog.model;

import com.example.music_catalog.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TrackConfig {

    @Bean
    CommandLineRunner commandLineRunner(TrackRepository repository) {
        return args -> {
            Track testSong1 = new Track(
                    "Test Song1",
                    "Artist1",
                    "Pop",
                    1999,
                    "testSong1.mp3",
                    "CD"
            );
            Track testSong2 = new Track(
                    "Test Song2",
                    "Artist2",
                    "Pop",
                    1999,
                    "testSong1.mp3",
                    "CD"
            );

            repository.saveAll(
                    List.of(testSong1, testSong2)
            );
        };
    }
}*/
