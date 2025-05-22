Employee API Endpoints
1. Create Employee
    Method: POST
    
    Path: /employees
    
    Description: Creates a new employee record.
    
    Request Body: JSON representing the employee data (validated).
  
    Response: The created employee details.

2. Get All Employees
   Method: GET

   Path: /employees

   Description: Retrieves a list of all employees. Optionally filters by department if the department query parameter is provided.

   Query Parameter:

   department (optional) - filter employees by department name.

   Response: List of employees.

3. Get Employee by ID
    Method: GET
    
    Path: /employees/{id}
    
    Description: Retrieves employee details by their unique ID.
    
    Path Parameter:
    
    id - Employee ID.
    
    Response: Details of the requested employee.

4. Update Employee
    Method: PUT
    
    Path: /employees/{id}
    
    Description: Updates the details of an existing employee.
    
    Path Parameter:
    
    id - Employee ID.
    
    Request Body: JSON representing updated employee data (validated).
    
    Response: The updated employee details.

5. Delete Employee
    Method: DELETE
    
    Path: /employees/{id}
    
    Description: Deletes an employee record by ID.
    
    Path Parameter:
    
    id - Employee ID.
    
    Response: Confirmation message of deletion.
