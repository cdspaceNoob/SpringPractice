package kr.co.softcampus.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.BoardInfoBean;

@Repository
public class TopMenuDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardInfoBean> getNavList(){
		List<BoardInfoBean> navList = sqlSessionTemplate.selectList("topmenu.getTopmenu_list");
		// 결과 row가 단 하나라면 selectOne을 사용하면 된다. 여러 줄이라면 selectList를 사용한다. 
		// 파라미터는 "namesapce.id"로 정해주면 된다. 
		
		return navList;
	}
}
