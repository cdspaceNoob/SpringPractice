package kr.co.softcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.softcampus.beans.UserBean;

// 프로젝트 작업 시 사용할 Bean을 정의하는 클래스
@Configuration
public class RootAppContext {

	// UserBean을 세션 스코프로 정의.(세션 범위에 생성되도록한다.) 이름으로 주입받을 수 있게 한다. 
	// UserBean은 내용의 특성상 다양하게 쓰이기 때문에 따로 Bean으로 정의해준다. 
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
	
}
