package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// 여기서 최초로 렌더링될 페이지가 설정된다. 
	// ContextPath = localhost:3306/ProjectName
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "redirect:/main";
	}
	
}
