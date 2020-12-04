package com.onlyxcodes.mvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyxcodes.mvcapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
