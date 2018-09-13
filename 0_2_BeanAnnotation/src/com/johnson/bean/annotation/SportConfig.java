package com.johnson.bean.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.johnson.bean.annotation")
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
