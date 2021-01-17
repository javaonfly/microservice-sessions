

Day2

    1. Add a new Config Server and Configure it use the GIT location for accessing properties file
    2. Update the product service to fetch a properties from Config Server and use a specific profile.
    3. Update a properties in the Config Server and see that its getting updated in the Config Server and Product Service without any restart
    4. Introduce Eureka Server
    5. Allow Product Server to get registered with Eureka Server
    6. Add Rest client with Rest Template and access product service with direct ip address
    7. Update the Rest Template to access the product Service through Eureka rather than direct access
    8. Introduce Feign Client
    9. Add Logging for Feign Client
    10. Add Resilience4j circuit breaker to Feign Client
    11. Add a Cloud Gateway and add route for Product Service
    12. Add a header in the response via Cloud Gateway
    13. Add a circuit breaker in the Cloud Gateway
    14. Show Re-Routing in Cloud Gateway
    15. Show Server loadbalancing using Cloud Gateway

Assignments:-

    1. Create an EmployeeDashboard application which call EmployeeService to get Employee details.
    2. Enable Failfast approach in Employee-Dashboard Service when Config server is down. Which means Product-server should startup if config-server is not running.
    3. Update a properties in the config service and see the effect in EmployeeDashboard application without restarting the application 
    4. (The Curl command to be used is
    5. curl http://localhost:<actual port>/actuator/refresh -d {} -H "Content-Type: application/json"
    6. Introduce a fallback mechanism in Employee Dashboard Service to populate with dummy data. 
    7. Start multiple instance of EmployeeService, In the Employee Description the server port of the Employee Service. (Use Environment as used in Dummy controller in product-service) and check the Client Loadbalancing in act. 
    8. Add one more path in the Employee Rest Service as /api/v2/employee 
    9.  Introduce Canary Deployment though API Gateway
    10. go through the link
    11. https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#the-weight-route-predicate-factory 
