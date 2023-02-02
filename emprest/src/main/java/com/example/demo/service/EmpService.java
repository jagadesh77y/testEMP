package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Employee;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;

	public Employee getEmpDetails(long id) {
		return empRepository.getById(id);
	}

	public boolean persistEmp(Employee emp) {
		// TODO Auto-generated method stub
		boolean message = false;
		Employee savedEmployee = empRepository.save(emp);
		if (savedEmployee != null) {
			message = true;
		}
		return message;
	}

	public boolean deleteEmp(Employee empData) {
		boolean message = false;
		Optional<Employee> emp = empRepository.findById(empData.getId());
		if (emp.isPresent()) {
			empRepository.delete(emp.get());
			message = true;
		}
		return message;
	}

	public boolean updateEmpData(Employee empData) {
		// TODO Auto-generated method stub
		boolean message = false;
		Optional<Employee> emp = empRepository.findById(empData.getId());
		if (emp.isPresent()) {
			Employee savedEmployee =  empRepository.save(empData);
			if (savedEmployee != null) {
				message = true;
			}
		}
		return message;

	}

}
