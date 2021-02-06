package org.javaonfly.cqrs.Employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.javaonfly.cqrs.Employee.repo.Employee;
import org.javaonfly.cqrs.Employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCQRSQueryService {
	
	@Autowired
	private  EventStore eventStore;

	@Autowired
    private  EmployeeRepository employeeRepository;

    
    public List listEventsForEmployee(Long id) {    	
    	System.out.println("Javaonfly fetch event for Id " + id);    	
    	Optional<Employee> emp = employeeRepository.findById(id);    	  
        List eventList = eventStore.readEvents(emp.isPresent()?emp.get().getEmployeeAgregratorId():"default").asStream().map( s -> s.getPayload()).collect(Collectors.toList());
        System.out.println("Java onfly printing Event List" + eventList);
		return eventList;
    }
    
    public Optional<Employee> findEmployee(Long id) {    	
    	Optional<Employee> emp = employeeRepository.findById(id);    	  
       	return emp;
    }
    
  

    
    

}
