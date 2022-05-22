package com.example.music_catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MusicTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicTestApplication.class, args);
	}

}
