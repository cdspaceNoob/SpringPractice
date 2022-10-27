package kr.co.softcampus.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.beans.factory.annotation.Autowired;	// 직접 주입받지 못하므로 @Autowired 쓰지 않는다. 
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.NavService;
//
public class NavInterceptor implements HandlerInterceptor{

	private NavService navService;	// 직접 주입받지 못하므로 @Autowired 쓰지 않는다.
	private UserBean loginUserBean;	// 로그인 여부를 알기 위해서.
	
	// NavInterceptor 객체가 생성될 때, NavService의 객체도 생성자를 통해 만들 것이다. 
	public NavInterceptor(NavService navService, UserBean loginUserBean) {
		this.navService 	= navService;
		this.loginUserBean  = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> navList = navService.getNavList();
		request.setAttribute("navList", navList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		return true;	// false이면 얘만 실행되고 이후는 실행되지 않게 된다. 
	}
	
	
}
