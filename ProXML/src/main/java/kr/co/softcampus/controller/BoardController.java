package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")	// 하위 주소를 설정해준다. "/board" 경로는 모두 여기를 거친다. 
public class BoardController {

	@GetMapping("/main")	// 사실상 요청을 받는 url은 "/board/main"이 된다. 
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		return "board/main";	// return 할 때는 jsp의 절대 경로를 적어주는 것이므로 "board/main"을 다 적어준다. 
	}
	
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
}
