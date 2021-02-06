

Day3 Items Covered

  1. CQRS Implementation with AXON.
  2. Down load Axon server from https://axoniq.io/product-overview/axon-framework
  3. Go to download location then locate axonserver.jar
  4. Start axon server using java -jar axonserver.jar command
  5. Run EmplyeeCQRS in  command profile mode by opening 
  #spring.profiles.active=Command
  #server.port:9092
  6. Run EmployeeCQRS in query profile mode by
  spring.profiles.active=Query
  server.port:9093
  
  7. Use http://localhost:9092/swagger-ui.html to create and update employee.
  8. Use http://localhost:9093/swagger-ui.html to see the applied events on a agrregrate.
  
  

Assignments:-

  1. Create Account CQRS implementation using AXON
  2. Create a Account aggregrator with accoint id, amount, account holder name, account state.
  3. Four commands and events will be there Account create/created commad, credit/Credited command , debit/Debited command & Hold Command.
  4. If Balance of account less than 500 it will fire a Hold event and account state will be marked as hold.
  5. In other cases account state remains active.
  6. Show the event applied on a account in query service.
  
