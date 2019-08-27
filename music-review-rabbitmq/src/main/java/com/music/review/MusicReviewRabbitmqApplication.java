package com.music.review;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MusicReviewRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicReviewRabbitmqApplication.class, args);
	}

}
