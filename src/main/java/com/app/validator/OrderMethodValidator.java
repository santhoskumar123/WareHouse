package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod om=(OrderMethod)target;
		//radio buttons empty check
		if(StringUtils.isEmpty(om.getOrderMode())) {
			errors.rejectValue("orderMode", null, "please choose one!!!");
		}
		//text check
		if(!StringUtils.hasText(om.getOrderCode())) {
			errors.rejectValue("orderCode", null, "please enter code!!!");
		}//pattern checking
		else if(!Pattern.matches("[A-Z]{4,6}",om.getOrderCode())){
			errors.rejectValue("orderCode", null, "code must be 4-6 upper case letters only!!!");
		}//drop down empty check
		if(StringUtils.isEmpty(om.getExeType())) {
			errors.rejectValue("exeType", null, "choose one option!!!");
		}
		//checkbox empty check
		if(om.getOrderAccept()==null || om.getOrderAccept().isEmpty()) {
			errors.rejectValue("orderAccept", null,"choose one or more option");
		}
		
		//Text area
		//a.hasNext b.size check
		if(!StringUtils.hasText(om.getOrderDsc())) {
			errors.rejectValue("orderDsc", null,"enter description!!!");
		}
		else if(om.getOrderDsc().length()>=20 && om.getOrderDsc().length()<=200) {
			errors.rejectValue("orderDsc", null,"chars must be 20-200 only!!!");
		}
		
	}

}
