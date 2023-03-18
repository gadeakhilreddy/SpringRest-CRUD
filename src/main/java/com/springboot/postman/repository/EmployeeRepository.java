package com.springboot.postman.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.postman.model.Employee;




public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
