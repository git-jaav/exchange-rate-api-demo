package com.jaav.sys.exchangerateapidemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = {"dev","local"})
class ExchangeRateApiDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
