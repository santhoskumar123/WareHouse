package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
@Component
public class ShipmentTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType st=(ShipmentType)target;
		//drop down checking
		if(!StringUtils.isEmpty(st.getShipmentMode())) {
			errors.rejectValue("shipmentMode", null, "choose one option!!!");
		}
		//text checking
		if(StringUtils.hasText(st.getShipmentCode())) {
			errors.rejectValue("shipmentCode", null, "please enter code!!!");
		}//pattern checking
		else if(!Pattern.matches("[A-Z]{4,6}",st.getShipmentCode())){
			errors.rejectValue("shipmentCode", null, "code must be 4-6 upper case letters only!!!");
		}

		//drop down checking
		if(StringUtils.isEmpty(st.getEnableShipment())) {
			errors.rejectValue("enableShipment", null, " choose any one yes or no!!!");
		}
		//radio buttons empty check
				if(StringUtils.isEmpty(st.getShipmentGrade())) {
					errors.rejectValue("shipmentGrade", null, "please choose one!!!");
				}

		//Text area
		//a.hasNext b.size check
		if(!StringUtils.hasText(st.getShipDesc())) {
			errors.rejectValue("shipDesc", null,"enter description!!!");
		}
		else if(st.getShipDesc().length()>=20 && st.getShipDesc().length()<=200) {
			errors.rejectValue("shipDesc", null,"chars must be 20-200 only!!!");
		}
	}

}
