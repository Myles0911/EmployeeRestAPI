package daos;

import entities.Employee;

import java.util.*;

public class LocalEmployeeDAO implements EmployeeDAO {
    private final Map<Integer, Employee> employee_table = new HashMap<Integer, Employee>();
    private int idCounter = 0;


    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(++this.idCounter);
        employee_table.put(this.idCounter, employee);
        return employee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        Set<Employee> employees = new HashSet<>(this.employee_table.values());
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = this.employee_table.get(id);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        this.employee_table.put(employee.getId(),employee);
        return employee;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
      Employee employee = employee_table.remove(id);
      return employee != null;
    }
}
