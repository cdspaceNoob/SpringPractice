package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
//		return "/WEB-INF/views/index.jsp";	// 이렇게 파일 경로를 직접 리턴할 수도 있다. JSP의 내용이 나온다.
		return "index";
	}
	
}
