package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softcampus.service.UserService;

@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/checkUserIdExist/{user_id}")	
	public String checkUserIdExist(@PathVariable String user_id) {	// 파라미터보다는 pathValue를 더 범용적으로 사용한다.
		
		boolean chk = userService.checkUserIdExist(user_id);
		
		return chk + "";
	}
	
}
