package com.springboot.postman;

import com.springboot.postman.model.Employee;
import com.springboot.postman.repository.EmployeeRepository;
import com.springboot.postman.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootPostmanApplicationTests {

	@MockBean
	private EmployeeRepository repo;

	@Autowired
	private EmployeeServiceImpl service;

   @Test
   public void getAllEmployeeTest(){

	   Mockito.when(repo.findAll()).thenReturn(Stream.of(new Employee(1,"A","b","a@gmail.com")
			                                         ,new Employee(2,"v","x","x@gmail.com"))
			                                          .collect(Collectors.toList()));
	   assertEquals(2,service.getAllEmployees().size());

   }
}
