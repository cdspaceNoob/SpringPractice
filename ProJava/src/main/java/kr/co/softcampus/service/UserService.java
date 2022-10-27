package kr.co.softcampus.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;	// 로그인이 성공하면 여기에 데이터 담아야 하니까.
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.CheckUserIdExist(user_id);
		
		if(user_name == null) {
			return true;	// 사용 가능한 아이디일 때 true
		} else {
			return false;	// 이미 존재하는 아이디일 때 false
		}
	}// eom
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}// eom
	
	public void GetLoginUserInfo(UserBean tempLoginUserBean) {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		// 조회 결과가 존재한다면 새로운 Bean(loginUserBean)을 가져와서 여기에 결과셋을 담아준다. 
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);	// 이 정보로 Controller에서 로그인 성공 여부를 판단할 것이다.
		}
	}// eom
	
}
