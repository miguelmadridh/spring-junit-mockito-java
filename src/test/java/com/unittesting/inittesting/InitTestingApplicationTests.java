package com.unittesting.inittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations = {"class:test-configurration.properties"})
class InitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
