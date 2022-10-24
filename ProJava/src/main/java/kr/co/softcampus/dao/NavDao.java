package kr.co.softcampus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.mapper.NavMapper;

@Repository
public class NavDao {

	@Autowired	// Mapper를 주입받는다. 
	private NavMapper navMapper;
	
	public List<BoardInfoBean> getNavList(){
		List<BoardInfoBean> navList = navMapper.getNavList();
		
		return navList;
	}
}
