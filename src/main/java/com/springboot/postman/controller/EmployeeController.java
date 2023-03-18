package com.springboot.postman.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.postman.model.Employee;
import com.springboot.postman.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee rest api
	
	@PostMapping("create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	@GetMapping("bye")
	public String bye() {
		return "Bye Bye!!!! Akhill";
	}
	
	//build get ALL Employee REST API
	
	@GetMapping("getall")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long Id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(Id),HttpStatus.OK);
		
	}
	
	//Build update employee by id Rest API
	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Succesfully!!!",HttpStatus.OK);
	}

}
