package org.javaonfly.cqrs.Employee.service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.javaonfly.cqrs.Employee.command.BaseEmployeeCommand;
import org.javaonfly.cqrs.Employee.command.UpdateEmployeeCommand;
import org.javaonfly.cqrs.Employee.dto.EmployeeDto;
import org.javaonfly.cqrs.Employee.repo.Employee;
import org.javaonfly.cqrs.Employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

	@Autowired
	RestTemplate template;
	
	@Autowired
	private CommandGateway commandGateway;
	@Autowired
	EmployeeRepository repo;

	public CompletableFuture<String> createCommand(EmployeeDto empDto) {
		
		  System.out.println("JavaOnFly :: Employee DTO" + empDto);	
		  BaseEmployeeCommand command = new
		  BaseEmployeeCommand(UUID.randomUUID().toString(),empDto.getCommandType(),empDto.getId(),empDto.getName(),empDto.getGender(),empDto.getStatus());
		  System.out.println("JavaOnFly :: Command send to Axon command BUS " + command);	
		  return commandGateway.send(command);
		  
		 
	}
	
	public CompletableFuture<String> updateommand(EmployeeDto empDto) {
		
		  System.out.println("JavaOnFly :: Employee DTO" + empDto);
		   ResponseEntity<Employee> response = template.getForEntity("http://localhost:9093/employees/"+empDto.getId(), Employee.class);
		   Employee emp = response.getBody();
		  	 if(emp.getEmployeeAgregratorId()!= null) {
			  System.out.println("JavaOnFly :: Updating Employee " + response.getBody());	
			  return commandGateway.send(new
					 UpdateEmployeeCommand(emp.getEmployeeAgregratorId(),empDto.getCommandType(),emp.getId(),empDto.getName(),emp.getGender(),empDto.getStatus()));
					  
		  }
		  return CompletableFuture.supplyAsync(()->"No Employee found in Locar Repository");
		 
		 
	}

}
