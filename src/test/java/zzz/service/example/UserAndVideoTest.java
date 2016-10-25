package zzz.service.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserAndVideoTest {

	BaseService<String, String> videoService;
	BaseService<String, Integer> userService;
	ServiceConfig config;
	
	@Before
	public void setUp() throws Exception {
		config = new ServiceConfig("Primo", "Secundo");
		videoService = new VideoService(config);
		userService = new UserService(config);
	}

	@Test
	public void test() {
		String result = videoService.call("Goodbye");
		assertThat(result, is("Video Service: Secundo"));
	}

}
