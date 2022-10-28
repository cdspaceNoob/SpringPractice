package kr.co.softcampus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.softcampus.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);	// UserBean을 제외하면 절차적 코드이다.(고정)
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName();
		System.out.println("validator: " + beanName);
		
		// 비밀번호 확인 기능: 회원가입 시 || 정보 수정 시  
					if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
						if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
							errors.rejectValue("user_pw", "NotEquals");
							errors.rejectValue("user_pw2", "NotEquals");
						}
					}//
					
					if(beanName.equals("joinUserBean")) {
						if(userBean.isUserIdExist() == false) {
							errors.rejectValue("user_id", "CheckUserIdExistNotDone");
						}
					}//
				}// eom

			}


