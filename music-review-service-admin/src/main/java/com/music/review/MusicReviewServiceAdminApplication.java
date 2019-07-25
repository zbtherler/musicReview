package com.music.review;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MusicReviewServiceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicReviewServiceAdminApplication.class, args);
	}

}
