package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.TestDAO;

@Service
// Controller로부터 지시를 받아 특정 기능을 수행하는 메서드가 정리된 곳이 Service 클래스다. 
// 얘도 @Component로 "얘는 빈이에요!"하는 거랑 다를 거 없다. 

public class TestService {

	@Autowired
	private TestDAO dao;
	
	public String testMethod() {
		
		// 만약 여기서 단순 연산이 아닌, 데이터베이스 관련 작업을 한다면?
		// DAO 클래스에 지시한다. 
		// DAO 클래스에는 @Repository 어노테이션을 붙여 명시한다. 
		String str = dao.TestDaoMethod();
		
		return str;
	}
	
}
