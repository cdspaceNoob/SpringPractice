package kr.co.softcampus.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;	// 직접 주입받지 못하므로 @Autowired 쓰지 않는다. 
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.service.TopMenuService;
//
public class TopMenuInterceptor implements HandlerInterceptor{

	@Autowired
	private TopMenuService topMenuService;	// Java 프로젝트와 달리 생성자 없이 바로 주입할 수 있다. 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> navList = topMenuService.getTopMenuList();
		request.setAttribute("navList", navList);
		
		return true;	// false이면 얘만 실행되고 이후는 실행되지 않게 된다. 
	}
	
	
}
