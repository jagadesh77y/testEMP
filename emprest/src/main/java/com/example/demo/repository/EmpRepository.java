package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{

}
