package kr.co.softcampus.dao;

import org.springframework.stereotype.Repository;

@Repository
// 이 클래스에선 DAO의 기능을 담당하고 있다고 동네방네 알리는 것이다. 
// 마찬가지로 @Component와 등록한 것과 차이는 없으며 명시적인 어노테이션이다. 

public class TestDAO {
	
	public String TestDaoMethod() {
		return "다오문자열";
	}
}
