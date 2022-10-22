package kr.co.softcampus.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/* 직접 작성하기에 자유도가 있는 코드 */
//public class SpringConfigClass implements WebApplicationInitializer{
//	// web.xml을 호출하는 대신 이 클래스를 대신 호출한다.
//	// web.xml의 내용이 여기에 담기게 된다.	
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		
//		
//		// Spring MVC 프로젝트 설정을 위해 작성해야 하는 클래스의 객체를 생성한다.
//		// web.xml에서 DispatcherServlet을 설정하는 작업이 Java 코드에서는 아래처럼 구현된다. 
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//		
//		// 요청 발생 시 요청을 처리하는 서블릿을 Spring의 DispatcherServlet으로 전환하여 설정한다.
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//		
//		// 부가 설정
//		servlet.setLoadOnStartup(1);	// 가장 먼저 로딩.
//		servlet.addMapping("/");		// 이 서블릿이 가장 먼저 요청을 받아들인다.
//		
//		// Bean을 정의(및 관리)하는 클래스를 명시한다.
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		// 리스너 설정.
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		// 파라미터 인코딩 설정.
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter",CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		// dispatcher 통과하면 필터 실행할 것이다
//		filter.addMappingForServletNames(null, false, "dispatcher");	
//	}
//}
	
	/* 자유도는 매우 떨어지지만 매우 간단하게 설정할 수 있는 코드 */
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	// DispatcherServlet에 매핑할 요청 주소를 설정
	// 위의 servlet.addMapping("/");	
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	// 프로젝트에서 사용할 Bean을 정의해놓은 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	// Parameter 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
}
