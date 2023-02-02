package com.example.demo.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.dto.Employee;

public class ValidateEmp implements Validator{

	@Override
	public boolean supports(Class<?> param) {
		
		return Employee.class.equals(param);
	}

	

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empname", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doj", "doj.required");
		
	}
}
