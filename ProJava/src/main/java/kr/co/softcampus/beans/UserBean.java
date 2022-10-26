package kr.co.softcampus.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	private int user_idx;
	
	@Size(min=2, max=4)				// 최소 두 글자, 최대 네 글자 .
	@Pattern(regexp = "[가-힣]*")		// 정규 표현식: 한글 표기.
	private String user_name;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;		// 비밀번호 확인을 위해서. 
	
	private boolean userIdExist;
	
	public UserBean() {				// 중복확인 수행 여부를 표시하기 위해서. 초깃값은 false.
		this.userIdExist = false;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	public boolean isUserIdExist() {
		return userIdExist;
	}
	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}
	
}
