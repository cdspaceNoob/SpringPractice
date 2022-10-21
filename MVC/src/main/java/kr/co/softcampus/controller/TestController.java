package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.service.TestService;

@Controller	
// Bean으로 등록될 클래스라는 것을 의미한다는 점에서 @Component와 동일하다. 
// 단, 이 클래스에서 Controller 역할을 할 것임을 의미한다. 
// 어떤 요청이 발생했을 때, 요청 정보를 분석하여 매핑되어 있는 기능을 호출한다. 

public class TestController {
	
	// Bean 목록에서 주입받을 것을 골라둔다. 
	@Autowired
	private TestService serv;

	@GetMapping("/test1")
	public String test1(Model model) {
		
		// 만약, 이 메서드에서 꽤 많은 비즈니스 로직을 처리해야 한다면?
		// Service 클래스에 지시한다.
		String str = serv.testMethod();
		model.addAttribute("str", str);
		
		return "test1";
	}
	
}
