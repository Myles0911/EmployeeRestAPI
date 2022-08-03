package services;

import daos.EmployeeDAO;
import Entities.Employee;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee signOnEmployee(Employee employee) {
        if(employee.getJobTitle().length() == 0) {
            throw new RuntimeException("Sorry, your employee id cannot be empty");
        }
        if(employee.getName().length() == 0) {
        throw new RuntimeException("Sorry, your name must be filled in");
        }

        Employee myE = this.employeeDAO.createEmployee(employee);
        return myE;
    }

    @Override
    public Employee getAllEmployees() {
        Set<Employee> employees = this.employeeDAO.getAllEmployees();
        return (Employee) employees;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    public Employee modEmployee(Employee employee) {
        if(employee.getJobTitle().length() == 0) {
            throw new RuntimeException("Sorry, your employee id cannot be empty");

        }
        if(employee.getName().length() == 0) {
            throw new RuntimeException(("Sorry, your name must be filled in"));

        }
        return this.employeeDAO.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean Success = this.employeeDAO.deleteEmployeeById(id);
        return Success;
    }
}
