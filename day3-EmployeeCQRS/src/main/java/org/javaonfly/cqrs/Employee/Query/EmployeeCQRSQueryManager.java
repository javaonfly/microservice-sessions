package org.javaonfly.cqrs.Employee.Query;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.javaonfly.cqrs.Employee.Aggregrator.EmployeeAggregrator;
import org.javaonfly.cqrs.Employee.Event.EmployeeBaseEvent;
import org.javaonfly.cqrs.Employee.repo.Employee;
import org.javaonfly.cqrs.Employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Query")
public class EmployeeCQRSQueryManager {

	@Autowired
	private EventSourcingRepository<EmployeeAggregrator> eventSourceRepo;
	@Autowired
	private EmployeeRepository localEmployeeRepo;

	@EventHandler
	public void on(EmployeeBaseEvent employeeBaseEvent) {
		
		System.out.println("Java Onfly Recived Event  " + employeeBaseEvent);
		saveinLocalRepo(buildEmployeeEntity(getEmployeeFromAxonEventStore(employeeBaseEvent)));
	}

	private EmployeeAggregrator getEmployeeFromAxonEventStore(EmployeeBaseEvent event) {
		return eventSourceRepo.load(event.getEmployeeAgregratorId()).getWrappedAggregate().getAggregateRoot();
	}

	private Employee buildEmployeeEntity(EmployeeAggregrator employeeAggregrator) {
		
		System.out.println("Java Onfly get Aggregrator from Event Store " + employeeAggregrator);
		Employee employee = findExistingEmployeeOrCreateInLocalStore(employeeAggregrator.getId()!=null?employeeAggregrator.getId():0L);

		employee.setEmployeeAgregratorId(employeeAggregrator.getEmployeeAgregratorId());
		//employee.setId(1L);
		employee.setGender(employeeAggregrator.getGender());
		employee.setName(employeeAggregrator.getName());
		employee.setCommandType(employeeAggregrator.getCommandType());
		employee.setStatus(employeeAggregrator.getStatus());
		return employee;
	}

	private Employee findExistingEmployeeOrCreateInLocalStore(Long id) {
		return localEmployeeRepo.findById(id).isPresent() ? localEmployeeRepo.findById(id).get() : new Employee();
	}

	private void saveinLocalRepo(Employee employee) {
		System.out.println("Java Onfly Save Employee Status in Local Repo" + employee);
		localEmployeeRepo.save(employee);
	}

}
