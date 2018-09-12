package com.johnson.bean.annotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements Fortune {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "HappyFortune";
	}

}
