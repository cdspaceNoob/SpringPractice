package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;	// 사용 가능한 아이디일 때 true
		} else {
			System.out.println("user_name: " + user_name);
			return false;	// 이미 존재하는 아이디일 때 false
		}
	}
	
//	public void addUserInfo(UserBean joinUserBean) {
//		userDao.addUserInfo(joinUserBean);
//	}
	
}
