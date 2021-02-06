

Day3 Items Covered

  1. CQRS Implementation with AXON.
  2. Down load Axon server from https://axoniq.io/product-overview/axon-framework
  3. Start axon by going to down load location the locate axonserver.jar
  4. Start axonn server using java -jar axonserver.jar command
  5. Run EmplyeeCQRS in  command profile mode by opening 
  #spring.profiles.active=Command
  #server.port:9092
  6. Runn EmployeeCQRS in quer profile mode by
  spring.profiles.active=Query
  server.port:9093
  
  7. Use http://localhost:9092/swagger-ui.html to craete and update employee
  8. Use http://localhost:9093/swagger-ui.html to see the applied events on a agrregrate
  
  

Assignments:-

  1. Create Account CQRS implementation using AXON
  2. Create a Account aggregrator with accoint id account amoiunt and account holder name, Account state.
  3. Three command will be there Account create commad, Credited command , Debited command, Hold Command
  4. If Balance of account less than 500 it will be fore Hold evenet and account state will be marked hold.
  5. In other cases account state is active.
  6. Show the event applied on a account in query.
  
