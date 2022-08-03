package services;

import Entities.Employee;

public interface EmployeeService {

    //Create
    Employee signOnEmployee (Employee employee);



    //Read
    Employee getAllEmployees();
    Employee getEmployeeByID(int id);

    //Update
    Employee modEmployee (Employee employee);

    //Delete
    boolean deleteEmployee(int id);
}
