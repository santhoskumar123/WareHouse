package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
@Component
public class UomValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom u=(Uom)target;
		if(StringUtils.isEmpty(u.getUomType())) {
			errors.rejectValue("uomType", null, "choose one option!!!");
		}

		if(StringUtils.hasText(u.getUomModel())) {
			errors.rejectValue("uomModel", null, "please enter model name!!!");
		}//pattern checking
		else if(!Pattern.matches("[A-Z]{10,15}",u.getUomModel())){
			errors.rejectValue("uomModel", null, "code must be 10-15 upper case letters only!!!");
		}
		//a.hasNext b.size check
				if(!StringUtils.hasText(u.getUomDes())) {
					errors.rejectValue("uomDes", null,"enter description!!!");
				}
				else if(u.getUomDes().length()>=20 && u.getUomDes().length()<=200) {
					errors.rejectValue("uomDes", null,"chars must be 20-200 only!!!");
				}
	}

}
