package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softcampus.beans.UserBean;

@Controller
public class HomeController {
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	// 여기서 최초로 렌더링될 페이지가 설정된다. 
	// ContextPath = localhost:3306/ProjectName
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println(loginUserBean);
		return "redirect:/main";
	}
	
}
