package dhbw.catalog.music.music_catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MusicCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicCatalogApplication.class, args);
    }

}
