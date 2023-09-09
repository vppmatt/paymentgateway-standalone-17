# paymentgateway-standalone

Instructions

The Payment Gateway is a sample Rest application created in Spring Boot, to demonstrate calling a REST api. The concept is that when a customer wishes to make a purchase on one of your company's websites, the purchase request gets sent via REST to the payment gateway server.

The normal use case is:

Client sends a POST request to http://localhost:8080/api/payment to request a new payment is attempted
The server responds to this request with a unique transaction ID
The client sends a GET request to http://localhost:8080/api/payment/{transactionId}
The server responds with the status of the payment request
In addition clients can:
Send a GET request to http://localhost:8080/api/payment to get a list of all payments attempted
Send a PUT request to http://localhost:8080/api/payment/{transactionId} to refund a payment
Clients must include a header containing a 3 letter code for the requesting system. Valid codes are BRL, RJK and MTY. You can only do a GET for a payment request with a matching requesting system code.

This page can be used to generate a rest request, and it will send it to the server. The equivalent CURL command will also be provided.

How to run this project
- copy the file  <a href="https://raw.githubusercontent.com/vppmatt/payment-gateway-standalone-starter/main/getpaymentgateway.bat" download>getpaymentgateway.bat</a> to your computer - save it in the workspace folder e.g. W:\workspace
- Open a command prompt 
- navigate to the workspace folder, type "getpaymentgateway" and press enter
- Fetch the dependencies defined in the POM.XML file and run the application

Alternatively to run it from the command line:

- Create a clone of the repository
- Review application.properties - the connection to a MySQL server needs to be set 
- Ensure you have created an empty database on the mysql server with a name matching that in application.properties.
- run the command: "mvnw clean compile package" to build the jar file
- execute the jar file with "java -jar target/paymentgateway-1.3.jar"

Once the file is up and running, open the paymentgatewayclient.html file in a browser to test the Rest API.
