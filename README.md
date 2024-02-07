Employee Management Java Spring Boot Application


Project Name	  -Employee Management
Abstract	      -This Java Spring Boot application serves as an Employee Management system, allowing users to perform various operations related to employee management.
Languages Used  -Java
IDE	            -Intellij Idea Professionl
Database	      -PostgresQL

1.Introduction about my project
•	The application follows a layered architecture including controller, service, repository, model, contract,validation and exception layers to ensure separation of concerns and maintainability.
•	Testing has conducted with the help of junit and Mockito

2. Features
•	Add Employee: Endpoint to add a new employee to the system.
•	Get Employee by ID: Endpoint to retrieve employee details based on their unique identifier.
•	Get Employees by Department: Endpoint to fetch all employees belonging to a specific department.

4. Technology Stack
•	Java
•	Spring Boot
•	Spring Data JPA

6. Entity Class
•	Employee entity(model) class representing the employees in the system. The fields of this class include:
o	ID: Unique identifier for the employee.
o	Name: Name of the employee.
o	Email: Email of the employee.
o	Department: Department to which the employee belongs.

5.Layers
•	Controller Layer
-The controller layer contains RESTful endpoints responsible for handling incoming HTTP requests and delegating the processing to the service layer.

•	Service Layer
-The service layer encapsulates the business logic of the application. It performs operations such as validation, exceptions, transformation, and interaction with the repository layer.

•	Repository Layer
-The repository layer interacts with the underlying database, providing methods for storing, retrieving, updating, and deleting employee records.

•	Model Layer
-	The model layer defines the data structures used within the application, including the Employee entity class.
•	Contract Layer
-The contract layer defines the API contracts between different layers of the application, ensuring proper communication and separation of concerns.

6. API Endpoints
•	Add Employee: POST /employees/addEmployee
•	Get Employee by ID: GET /employees/{id}
•	Get Employees by Department: GET /employees/get-byDepartment?department={department}

7.Tests
•	JUnit 
•	Mockito
