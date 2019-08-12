package com.music.review;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.music.review.sender.DirectSender;
import com.music.review.sender.FanoutSender;
import com.music.review.sender.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicReviewRabbitmqApplicationTests {
	
	@Autowired
    private FanoutSender fanoutSender;
	
	@Autowired
    private DirectSender directSender;
	
	@Autowired
	private TopicSender topicSender;
	
	@Test
	public void testFanout() throws Exception {
		fanoutSender.send("111");
	}
	
	/**
     * DIRECT测试
     * @throws Exception
     */
    @Test
    public void testDirect() throws Exception {
        directSender.send("222");
    }
    
    /**
     * TOPIC测试
     * @throws Exception
     */
    @Test
    public void testTopic() throws Exception {
        topicSender.send("333");
    }


	public void contextLoads() {
	}

}
