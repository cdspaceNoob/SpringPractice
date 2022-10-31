package kr.co.softcampus.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softcampus.beans.UserBean;

@Controller
public class HomeController {
	
	@Resource(name="loginUserBean")	// 이름으로 주입받기 테스트. 
	private UserBean loginUserBean;
	
	// 여기서 최초로 렌더링될 페이지가 설정된다. 
	// ContextPath = localhost:3306/ProjectName
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request) {
//		System.out.println(loginUserBean);	// 이름으로 Bean 주입 확인.
		
		System.out.println(request.getServletContext().getRealPath("/"));	// 실제 배포 경로 확인.
		
		return "redirect:/main";
	}
	
}
