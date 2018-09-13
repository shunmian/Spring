package com.johnson.bean.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.johnson.bean.annotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public Fortune easyFortune() {
		return new EasyFortune();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(this.easyFortune());
	}
}
