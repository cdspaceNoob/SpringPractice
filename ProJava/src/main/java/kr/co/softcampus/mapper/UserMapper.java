package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softcampus.beans.UserBean;

public interface UserMapper {

	// 아아디 중복체크 
	@Select("select user_name "
			+ "from user_table "
			+ "where user_id = #{user_id}")
	String CheckUserIdExist(String user_id);
	
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) "
			+ "values (null, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean userBean);
	
	@Select("select user_idx, user_name "
			+ "from user_table "
			+ "where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);	// 결과셋을 UserBean으로 반환한다. 이 메서드를 호출하기 위한 파라미터는 UserBean이다.
	
	// 회워 개인 정보 수정 
	@Select("select user_id, user_name "
			+ "from user_table "
			+ "where user_idx=#{user_idx}")
	UserBean getModifyUserInfo(int user_idx);
	
	@Update("update user_table "
			+ "set user_pw=#{user_pw} "
			+ "where user_idx=#{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
	
}
