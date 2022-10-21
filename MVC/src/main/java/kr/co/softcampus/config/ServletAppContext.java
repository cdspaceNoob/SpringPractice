package kr.co.softcampus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 보통 ServletContext 또는 AppContext는 Spring MVC 프로젝트의 전반에 관련된 설정을 담고 있는 클래스다.

@Configuration	// Bean을 관리하는 Beans.xml과 동일한 역할을 한다. 이 어노테이션이 있는 클래스 내부에 @Bean을 설정한다.
@EnableWebMvc	
@ComponentScan("kr.co.softcampus.controller")
@ComponentScan("kr.co.softcampus.service")
@ComponentScan("kr.co.softcampus.dao")
// 스캔할 패키지를 지정한다. 해당 경로를 스캔하여 @Component를 모두 가져온 후, 이 패키지에서 @Bean으로 관리할 것이다.
// @Controller 또한 @Component의 일종이므로, 결국 @Controller를 모두 가져와서 @Bean으로 관리할 것임을 의미한다.
// 요청이 발생했을 때 해당 요청에 대해 어떤 Controller를 사용할지를 여기서 정하게 되는 것이다. 

public class ServletAppContext implements WebMvcConfigurer{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");	// 불러올 jsp 파일의 이름만 남도록 설정. 
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");	// 위와 같이 정적 파일 경로 설정.
	}
}
