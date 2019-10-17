package com.music.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicReviewNettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicReviewNettyApplication.class, args);
		/**
		 * 启动netty服务端服务
		 */
		try {
			new BootNettyServer().bind(6668);
			System.out.println( "Hello World!" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
