package org.javaonfly.cqrs.Employee.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.javaonfly.cqrs.Employee.dto.EmployeeDto;
import org.javaonfly.cqrs.Employee.service.EmployeeCQRSQueryService;
import org.javaonfly.cqrs.Employee.service.EmployeeService;
import org.javaonfly.cqrs.Employee.util.EmployeeCommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;


@Profile("Command")
@RestController
@RequestMapping(value = "/employees")
public class EmployeeCommandController {
	
	@Autowired
	EmployeeService employeeService;

	
	@Operation(description = "Create an Employee")
	@PostMapping(value = "/")
	public String createEmployee(@RequestBody EmployeeDto employeeDto) throws InterruptedException, ExecutionException {
		employeeDto.setCommandType(EmployeeCommandType.CREATION.name());	
		CompletableFuture<String> value =  employeeService.createCommand(employeeDto);
		return value.get();
	}
	
	@Operation(description = "update an Employee with a given id")
	@PutMapping(value = "/")
	public String updateEmployee(@RequestBody EmployeeDto employeeDto) throws InterruptedException, ExecutionException {
		employeeDto.setCommandType(EmployeeCommandType.UADATION.name());	
		CompletableFuture<String> value =  employeeService.updateommand(employeeDto);
		return value.get();
	}
	

}
