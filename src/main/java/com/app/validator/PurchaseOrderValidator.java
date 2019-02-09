package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder po=(PurchaseOrder)target;
		//text check
				if(!StringUtils.hasText(po.getOrderCode())) {
					errors.rejectValue("orderCode", null, "please enter code!!!");
				}//pattern checking
				else if(!Pattern.matches("[A-Z]{4,6}",po.getOrderCode())){
					errors.rejectValue("orderCode", null, "code must be 4-12 upper case letters only!!!");
				}
				//drop down empty check
				if(StringUtils.isEmpty(po.getShipmentMode())) {
					errors.rejectValue("shipmentMode", null, "choose one option!!!");
				}
				//drop down empty check
				if(StringUtils.isEmpty(po.getVendor())) {
					errors.rejectValue("vendor", null, "choose one option!!!");
				}//empty check
				if(po.getRefNum().isEmpty()) {
					errors.rejectValue("refNum", null, "enter ref number");
				}
				
				//radio buttons empty check
				if(StringUtils.isEmpty(po.getQualityCheck())) {
					errors.rejectValue("qualityCheck", null, "please choose one!!!");
				}
				//Text area
				//a.hasNext b.size check
				if(!StringUtils.hasText(po.getOrderDsc())) {
					errors.rejectValue("orderDsc", null,"enter description!!!");
				}
				//empty check
				if(po.getOrderStatus().isEmpty()) {
					errors.rejectValue("orderStatus", null, "enter order status");
				}
				else if(po.getOrderDsc().length()<=20 && po.getOrderDsc().length()>200) {
					errors.rejectValue("orderDsc", null,"chars must be 20-200 only!!!");
				}
	}

}
