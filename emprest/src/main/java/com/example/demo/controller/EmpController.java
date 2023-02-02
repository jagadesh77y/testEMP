package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmpService;
import com.example.demo.validations.ValidateEmp;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/emp")
public class EmpController {

	@Autowired
	EmpService empService;

	@GetMapping
	public ResponseEntity<Employee> getEmpDetails(@Valid @PathParam(value = "id") long id) {
		Employee emp = empService.getEmpDetails(id);
		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> persisitEmp(@Valid @RequestBody Employee emp) {

		boolean statusMessage = empService.persistEmp(emp);
		if (statusMessage == true) {
			return new ResponseEntity<>("data got Saved with ID :" + emp.getId(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("data is not Saved with ID :" + emp.getId(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping
	public ResponseEntity<String> DeleteEmp(@Valid @RequestBody Employee emp) {
		boolean statusMessage = empService.deleteEmp(emp);
		if (statusMessage == true) {
			return new ResponseEntity<>("data got deleted with ID :" + emp.getId(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("data is not present to delete with ID :" + emp.getId(),
					HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<String> updateEmp( @Valid  @RequestBody Employee emp) {
		boolean statusMessage = empService.updateEmpData(emp);
		if (statusMessage == true) {
			return new ResponseEntity<>("data got updated with ID :" + emp.getId(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("data is not updated with ID :" + emp.getId(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
