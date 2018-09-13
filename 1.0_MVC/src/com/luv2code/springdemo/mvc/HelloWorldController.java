package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hi")
public class HelloWorldController {
	@RequestMapping("/helloworld")
	public String showPage() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String showStudent() {
		return "helloworld-student";
	}
	
	@RequestMapping("/processFormV2")
	public String showStudentV2(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo! " + theName;
		
		model.addAttribute("message", result);
		
		
		return "helloworld-student";
	}
	
	@RequestMapping("/processFormV3")
	public String showStudentV3(@RequestParam("studentName") String theName, Model model) {
		
		theName = theName.toUpperCase();
		
		String result = "Yo V3! " + theName;
		
		model.addAttribute("message", result);
		
		
		return "helloworld-student";
	}
}
