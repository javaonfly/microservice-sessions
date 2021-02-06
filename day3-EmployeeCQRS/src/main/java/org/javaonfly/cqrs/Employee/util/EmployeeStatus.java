package org.javaonfly.cqrs.Employee.util;

public enum EmployeeStatus {

	CREATED("Created"), UPDATED("Updated"), INTIATED_SEPARATION("INTIATED_SEPARATION"), DELETED("DELETED");

	private String empStatus;
	EmployeeStatus(String status) {
		this.empStatus = status;
	}
	
	public static EmployeeStatus mapCommandToStatus(EmployeeCommandType type) {
		
		EmployeeStatus resultStatus = CREATED;
		if(type.equals(EmployeeCommandType.CREATION)) {
			resultStatus = CREATED;
		}else if(type.equals(EmployeeCommandType.UADATION)){
			resultStatus = UPDATED;
		}
		else if(type.equals(EmployeeCommandType.INTIATE_SEPARATION)){
			resultStatus = INTIATED_SEPARATION;
		}
		
		else if(type.equals(EmployeeCommandType.DELETION)){
			resultStatus = DELETED;
		}
		return resultStatus;
		
	}
	
	

}
