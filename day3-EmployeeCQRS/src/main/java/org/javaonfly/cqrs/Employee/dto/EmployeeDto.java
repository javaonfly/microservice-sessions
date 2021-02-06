package org.javaonfly.cqrs.Employee.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeDto {
	
	private String employeeAgregratorId;
	private Long id;
	private String name;
	private String gender;
	private String status;
	private String commandType;

}
