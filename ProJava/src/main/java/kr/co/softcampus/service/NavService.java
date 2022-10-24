package kr.co.softcampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.dao.NavDao;

@Service
public class NavService {

	@Autowired	// dao를 주입받는다.
	private NavDao navDao;
	
	public List<BoardInfoBean> getNavList(){
		List<BoardInfoBean> navList = navDao.getNavList();
		return navList;
	}
}
