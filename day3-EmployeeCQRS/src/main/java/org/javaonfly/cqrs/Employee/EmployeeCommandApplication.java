package org.javaonfly.cqrs.Employee;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.javaonfly.cqrs.Employee.Aggregrator.EmployeeAggregrator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class EmployeeCommandApplication {

	/*
	 * This will Create Axon Eventstore Repository Spring managed Instance, by which
	 * we can seamlessly call Axon EventStore
	 */
	@Bean
	EventSourcingRepository<EmployeeAggregrator> employeeAggregateEventSourcingRepository(EventStore eventStore) {
		EventSourcingRepository<EmployeeAggregrator> repository = EventSourcingRepository
				.builder(EmployeeAggregrator.class).eventStore(eventStore).build();
		return repository;
	}
	
	@Bean
    public OpenAPI customOpenAPI() {
     return new OpenAPI()
          .info(new Info()
          .title("Employee application API")
          .version("1,0")
          .description("CQRS Employee Application")
          .termsOfService("http://swagger.io/terms/")
          .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCommandApplication.class, args);
	}

}
