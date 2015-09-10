package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PropertyConfig;
import service.LoggerServiceTest.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class, PropertyConfig.class })
public class LoggerServiceTest {
	@Autowired
	private LoggerService loggerService;
	
	@Test
	public void log() {
		loggerService.log("uno");
		loggerService.log("dos");
	}
	
	@Configuration
	public static class Config {
		@Bean
		public LoggerService loggerService() {
			return new LoggerServiceImpl();
		}
	}
}
