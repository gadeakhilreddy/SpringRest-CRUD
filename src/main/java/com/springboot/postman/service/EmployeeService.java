package com.springboot.postman.service;

import java.util.List;

import com.springboot.postman.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, Long id);
	void deleteEmployee(long id);
}
