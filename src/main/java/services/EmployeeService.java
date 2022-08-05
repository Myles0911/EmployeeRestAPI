package services;

import entities.Employee;

import java.util.Set;

public interface EmployeeService {

    //Create
    Employee signOnEmployee (Employee employee);



    //Read
   Set<Employee> getAllEmployees();
    Employee getEmployeeByID(int id);

    //Update
    Employee modEmployee (Employee employee);

    //Delete
    boolean deleteEmployee(int id);
}
