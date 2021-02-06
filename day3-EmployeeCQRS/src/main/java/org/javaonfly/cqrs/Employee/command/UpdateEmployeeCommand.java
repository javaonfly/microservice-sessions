package org.javaonfly.cqrs.Employee.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UpdateEmployeeCommand extends BaseEmployeeCommand {

	public UpdateEmployeeCommand(String aggregateId, String command, Long id, String name, String gender,
			String status) {
		
		super(aggregateId,command,id,name,gender,status);

	}
}
