package kr.co.softcampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.dao.TopMenuDao;

@Service
public class TopMenuService {

	@Autowired	// dao를 주입받는다.
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> navList = topMenuDao.getNavList();
		return navList;
	}
}
