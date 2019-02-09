package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item i=(Item)target;
		//text check
		if(StringUtils.hasText(i.getItemCode())) {
			errors.rejectValue("itemCode", null, "please enter code!!!");
		}//pattern checking
		else if(!Pattern.matches("[A-Z]{4,6}",i.getItemCode())){
			errors.rejectValue("itemCode", null, "code must be 4-12 upper case letters only!!!");
		}
		//length checking
		if(i.getItemLen()==null||i.getItemLen()<0.0) {
			errors.rejectValue("itemLen", null, "Item length must be >0!!!");
		}
		/*if(i.getItemWidth()<=0) {
			errors.rejectValue("itemLen", null, "Item width must be >0!!!");
		}
		if(i.getItemHeight()<=0) {
			errors.rejectValue("itemLen", null, "Item height must be >0!!!");
		}
		if(i.getBaseCost()<=0) {
			errors.rejectValue("itemLen", null, "base cost must be >0!!!");
		}*/


		//drop down empty check
		if(StringUtils.isEmpty(i.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "choose one option!!!");
		}
		//Text area
		//a.hasNext b.size check
		if(!StringUtils.hasText(i.getItemDsc())) {
			errors.rejectValue("itemDsc", null,"enter description!!!");
		}
		else if(i.getItemDsc().length()<=20 && i.getItemDsc().length()>200) {
			errors.rejectValue("orderDsc", null,"chars must be 20-200 only!!!");
		}


	}

}
