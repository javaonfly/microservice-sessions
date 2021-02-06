package org.javaonfly.cqrs.Employee.Aggregrator;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.javaonfly.cqrs.Employee.Event.EmployeeBaseEvent;
import org.javaonfly.cqrs.Employee.command.BaseEmployeeCommand;
import org.javaonfly.cqrs.Employee.command.UpdateEmployeeCommand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Aggregate//command for to mark this as an aggregate object to Axon
public class EmployeeAggregrator {

	@AggregateIdentifier//axon to identyfy as primary key
	private String employeeAgregratorId;//null
	private Long id;//localdata base id
	private String name;
	private String gender;
	private String status;
	private String commandType;

	@CommandHandler
	public  EmployeeAggregrator(BaseEmployeeCommand baseCommand) {
		employeeDomainEventPublishFactory(baseCommand);

	}
	
	@CommandHandler
	public void on(UpdateEmployeeCommand updateCommand) {
		employeeDomainEventPublishFactory(updateCommand);

	}
	
	@EventSourcingHandler
	public void on(EmployeeBaseEvent event) {
		System.out.println("Java Onfly Rehydrate Aggregrator Id from Event  " + event);
		this.employeeAgregratorId=event.getEmployeeAgregratorId();
		this.id=event.getId();
		this.commandType= event.getCommandType();
		this.gender = event.getGender();
		this.name=event.getName();
		this.status=event.getStatus();

	}
	
	

	private void employeeDomainEventPublishFactory(BaseEmployeeCommand baseCommand) {
		EmployeeBaseEvent event = new EmployeeBaseEvent().populateEvent(baseCommand);
		System.out.println("JavaOnFly :: Domain Evenet Fired " + event);
		this.employeeAgregratorId = baseCommand.getEmployeeAgregratorId();				
		AggregateLifecycle.apply(event);
	}

}
