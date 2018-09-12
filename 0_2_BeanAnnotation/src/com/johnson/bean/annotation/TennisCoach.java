package com.johnson.bean.annotation;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String exercise() {
		return "Tennis 10 mins";
	}

}
