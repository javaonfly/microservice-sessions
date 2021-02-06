package org.javaonfly.cqrs.Employee.util;

public enum EmployeeCommandType {
	CREATION("Creation"), UADATION("Updation"), INTIATE_SEPARATION("INTIATE_SEPARATION"), DELETION("DELETION");

	private String command;

	EmployeeCommandType(String comand) {
		this.command = command;
	}

}
