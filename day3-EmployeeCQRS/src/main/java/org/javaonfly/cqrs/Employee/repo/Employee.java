package org.javaonfly.cqrs.Employee.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String employeeAgregratorId;
	private String commandType;
	private String name;
	private String gender;
	private  String status;
}