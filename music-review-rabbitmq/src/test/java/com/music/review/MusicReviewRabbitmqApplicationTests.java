package com.music.review;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.music.review.sender.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicReviewRabbitmqApplicationTests {
	
	@Autowired
    private FanoutSender fanoutSender;
	
	@Test
	public void testFanout() throws Exception {
		fanoutSender.send("111");
	}

	public void contextLoads() {
	}

}
