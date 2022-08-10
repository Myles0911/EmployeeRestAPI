package daos;

import entities.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeDAO {

 //create
Employee createEmployee (Employee employee);


//Read
Set<Employee> getAllEmployees();
Employee getEmployeeById(int id);

//Update
Employee updateEmployee(Employee employee);


    //Delete
    boolean deleteEmployeeById(int id);




}
