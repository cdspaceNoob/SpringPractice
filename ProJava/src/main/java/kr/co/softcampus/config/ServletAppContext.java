package kr.co.softcampus.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.softcampus.interceptor.NavInterceptor;
import kr.co.softcampus.mapper.BoardMapper;
import kr.co.softcampus.mapper.NavMapper;
import kr.co.softcampus.service.NavService;

// 얘는 Spring MVC 프로젝트에 관련된 설정을 담고 있는 클래스다.
@Configuration	// Bean을 관리하는 Beans.xml과 동일한 역할을 한다. 이 어노테이션이 있는 클래스 내부에 @Bean을 설정한다.
@EnableWebMvc	
@PropertySource("/WEB-INF/properties/db.properties")
@ComponentScan("kr.co.softcampus.controller")	// 스캔할 패키지를 지정한다.(스캔하여 가져온 후 이 패키지에서 @Bean으로 관리할 것이다)
@ComponentScan("kr.co.softcampus.dao")
@ComponentScan("kr.co.softcampus.service")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private NavService navService;
	
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
	
	// 데이터베이스 접속 정보를 관리하는 객체.
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);

		return source;
	}
	
	// 쿼리 및 접속 정보를 관리하는 객체.
	@Bean
	public SqlSessionFactory factory(BasicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		SqlSessionFactory factory = factoryBean.getObject();
		
		return factory;
	}
	
	// 쿼리 전송을 위한 객체. BoardMapper를 관리한다.
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		
		return factoryBean;
	}
	
	// 쿼리 전송을 위한 객체. NavMapper를 관리한다.
	@Bean
	public MapperFactoryBean<NavMapper> getNavMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<NavMapper> factoryBean = new MapperFactoryBean<NavMapper>(NavMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		
		return factoryBean;
	}
	
	// Interceptor 등록.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		NavInterceptor navInterceptor = new NavInterceptor(navService);	// Interceptor를 등록하는 쪽에서 주입받고, 생성자에 넣어준다. 
		
		InterceptorRegistration reg1 = registry.addInterceptor(navInterceptor);
		reg1.addPathPatterns("/**");
	}
	
	@Bean	// db property와 messageSourge를 구별하기 위해.
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}
}
