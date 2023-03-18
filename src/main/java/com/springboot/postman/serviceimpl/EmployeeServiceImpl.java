package com.springboot.postman.serviceimpl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.postman.exception.ResourceNotFoundException;
import com.springboot.postman.model.Employee;
import com.springboot.postman.repository.EmployeeRepository;
import com.springboot.postman.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	//@Autowired is required but only one constructor no need right now
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	

	@Override
	public Employee getEmployeeById(long id) {
		
		
		// We can use Lamda expression instead of if else
		
//Optional<Employee> emp = employeeRepository.findById(id);			
//		if(emp.isPresent()) {
//			return emp.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id",id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
	}


	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		
		//We need to check whether employee with given id exist in db or not
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exception", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
	}

	
	
}
