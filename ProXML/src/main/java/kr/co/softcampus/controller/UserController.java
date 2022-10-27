package kr.co.softcampus.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.UserService;
import kr.co.softcampus.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 성공 시 데이터를 담을 Bean. 여기서도 또 받는다?
	// 이미 세션 영역에 생성되어 있는 loginUserBean의 정보를 받겠다는 뜻이다. 
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;	 

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
						@RequestParam(value="fail", defaultValue="false") boolean fail, Model model) {	
						// "fail" key의 value를 받아서 fail이라는 변수에 할당할 건데, 안 남어온다면 기본값은 false.
		
		model.addAttribute("fail", fail);
		
		return "user/login";
	}// eom
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.GetLoginUserInfo(tempLoginUserBean);
		
		if(loginUserBean.isUserLogin()) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}// eom
	
	@GetMapping("/join")	// userBean을 주입하고 model에 얹어준다. 
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}// eom
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/join";
		} 
		
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success";
	}// eom
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}// eom
	
	@GetMapping("/logout")
	public String logout() {
		
		loginUserBean.setUserLogin(false);
		
		return "user/logout";
	}// eom
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}// eom
	
}
