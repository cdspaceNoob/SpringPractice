package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.UserBean;

public interface UserMapper {

	@Select("select user_name "
			+ "from user_table "
			+ "where user_id = #{user_id}")
	String CheckUserIdExist(String user_id);
	
	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) "
			+ "values (null, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean userBean);
	
	
}
