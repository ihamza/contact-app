run the app using 
mvn spring-boot:run
OR
you can compile/build the source code using maven mvn package
then run the jar using java -jar jar-file.jar

a- open browser http://localhost:8080/swagger-ui.html
c- open h2 web console at
http://localhost:8080/h2
login with JDBC URL:	 jdbc:h2:mem:testdb 
User Name:	sa
No password

=== Insert and retrieve data
http://localhost:8080/swagger-ui.html
1- create multi contacts 
section admin 
POST /v1.0/employee/ create Employee
CREDENTIALS user=admin password=password
u can use sample like this
{
  "email": "mail@me.com",
  "name": "user",
  "phone": "+20111222333"
}

2- view contacts for clients
us can open this is browser 
http://localhost:8080/v1.0/viewemployee/
OR using swagger 
section client
GET /v1.0/viewemployee/
it will retrieve latest 3 contacts
