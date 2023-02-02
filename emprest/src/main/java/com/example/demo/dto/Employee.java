package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	@Column(name="emp_name")
	private String empName;
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	@Column(name = "dob")
	private LocalDate dob;
	
	public Employee(Long id, String empName, LocalDate joiningDate, LocalDate dob) {
		super();
		this.id = id;
		this.empName = empName;
		this.joiningDate = joiningDate;
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
