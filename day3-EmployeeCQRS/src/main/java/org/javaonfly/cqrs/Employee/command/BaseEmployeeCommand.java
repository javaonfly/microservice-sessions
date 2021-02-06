package org.javaonfly.cqrs.Employee.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEmployeeCommand {
	
	@TargetAggregateIdentifier// Axon server Command will applied on this aggregtor.
	private String employeeAgregratorId;
	private String commandType;
	private Long id;
	private String name;
	private String gender;
	private  String status;
	

}
