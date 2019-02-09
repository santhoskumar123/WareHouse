package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType ut=(WhUserType)target;
		//radio buttons check
		if(StringUtils.isEmpty(ut.getUserType())) {
			errors.rejectValue("userType", null, "please choose one!!!");
		}
		
		//text check
		//a.hasNext b.size check
				if(!StringUtils.hasText(ut.getUserCode())) {
					errors.rejectValue("userCode", null,"enter code!!!");
				}
				else if(ut.getUserCode().length()>=10 && ut.getUserCode().length()<=15) {
					errors.rejectValue("userCode", null,"chars must be 10-15 letters only!!!");
				}
				//text check
				if(!StringUtils.hasText(ut.getUserFor())) {
					errors.rejectValue("userFor", null,"enter code!!!");
				}
				//number check
				if(!StringUtils.hasText(ut.getUserContact())) {
					errors.rejectValue("userContact", null,"enter contact number!!!");
				}
				//drop down empty check
				if(StringUtils.isEmpty(ut.getUserIdType())) {
					errors.rejectValue("userIdType", null, "choose one option!!!");
				}
				//text check
				if(!StringUtils.hasText(ut.getIfOther())) {
					errors.rejectValue("ifOther", null,"enter some thing");
				}
				if(!StringUtils.hasText(ut.getIdNumber())) {
					errors.rejectValue("idNumber", null,"enter id");
				}
				
				
		
	}
}
