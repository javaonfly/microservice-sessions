package org.javaonfly.cqrs.Employee.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.javaonfly.cqrs.Employee.repo.Employee;
import org.javaonfly.cqrs.Employee.service.EmployeeCQRSQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@Profile("Query")
@RestController
@RequestMapping(value = "/employees")
public class EmployeeQueryController {	
	
	@Autowired
	EmployeeCQRSQueryService cqrsService;
	
		
	
	@Operation(description = "Get All events from Event store for an Employee")
	@GetMapping(value = "/{empid}")
	public Employee getEmployeeFromRepo(@PathVariable("empid") Long id) throws InterruptedException, ExecutionException {
		System.out.println("Javaonfly calling Local Repo" + id);
		Optional<Employee> employee =  cqrsService.findEmployee(id);
		 return employee.isPresent()?employee.get():new Employee(id,null,null,null,null,null);
	
	}
	
	
	@Operation(description = "Get All events from Event store for an Employee")
	@GetMapping(value = "/events/{empid}")
	public List getEmployeeEvent(@PathVariable("empid") Long id) throws InterruptedException, ExecutionException {
		System.out.println("Javaonfly calling getEmployeeEvent" + id);
		return cqrsService.listEventsForEmployee(id);
	
	}

}
