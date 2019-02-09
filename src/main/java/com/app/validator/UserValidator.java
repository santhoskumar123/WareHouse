package com.app.validator;



import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.User;


@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u=(User)target;
		if(!StringUtils.hasText(u.getUserName())) {
			errors.rejectValue("userName", null,"enter name!!!");
		}
		if(StringUtils.hasText(u.getUserEmail())) {
			errors.rejectValue("userEmail", null, "please enter mail!!!");
		}
		if(StringUtils.hasText(u.getUserPwd())) {
			errors.rejectValue("userPwd", null, "please enter valid password!!!");
		}
		
		if(StringUtils.hasText(u.getMobile())) {
			errors.rejectValue("mobile", null, "please enter mobilenumber!!!");
		}
		if(StringUtils.isEmpty(u.getRoles())) {
			errors.rejectValue("roles", null, "choose one option!!!");
		}
	}

	

	

}
