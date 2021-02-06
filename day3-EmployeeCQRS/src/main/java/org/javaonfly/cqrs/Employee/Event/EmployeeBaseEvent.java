package org.javaonfly.cqrs.Employee.Event;

import org.javaonfly.cqrs.Employee.command.BaseEmployeeCommand;
import org.javaonfly.cqrs.Employee.util.EmployeeCommandType;
import org.javaonfly.cqrs.Employee.util.EmployeeStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBaseEvent {
	
	private String employeeAgregratorId;
	private String commandType;
	private Long id;
	private String name;
	private String gender;
	private  String status;
	
	public EmployeeBaseEvent populateEvent(BaseEmployeeCommand command) {
		this.employeeAgregratorId= command.getEmployeeAgregratorId();
		this.commandType=command.getCommandType();
		this.id = command.getId();
		this.name = command.getName();
		this.gender=command.getGender();
		this.status = EmployeeStatus.mapCommandToStatus(EmployeeCommandType.valueOf(command.getCommandType())).name();
		return this;
	}

}
