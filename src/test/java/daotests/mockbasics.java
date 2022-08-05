package daotests;

import daos.EmployeeDAO;
import daos.EmployeeDaoPostgres;
import entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.EmployeeService;
import services.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class mockbasics {
/*
    @Test
    void mock_1() {
        List<String> mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.get(99)).thenReturn("Bowser");
        System.out.println(mockedList.get(99));
    }
    @Test
    void saved_employees_must_have_a_job_title() {
        EmployeeDAO employeeDAO = Mockito.mock(EmployeeDAO.class);
        Mockito.when((employeeDAO.createEmployee(employee)).thenReturn(employee);
        EmployeeService employeeService = new EmployeeServiceImpl(null);
        employeeService.signOnEmployee(new Employee(0, "Knight", "Emile"));

        Assertions.assertThrows(RuntimeException.class, ()->{
            employeeService.signOnEmployee(employee); });
        }

        @Test
        void sort_by_title() {
        EmployeeDAO employeeDAO = Mockito.mock(EmployeeDAO.class);
        List<Employee> fakeEmployee = new ArrayList();
        fakeEmployee.add(new Employee(0, "A", "C"));
            fakeEmployee.add(new Employee(0, "A", "C"));
            fakeEmployee.add(new Employee(0, "B", "D"));
            fakeEmployee.add(new Employee(0, "E", "F"));
            Mockito.when(EmployeeDAO.getAllEmployees()).thenReturn(fakeEmployee);

            EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);
            List<Employee> sortedEmployees = employeeService.signOnEmployee("A");
            Assertions.assertEquals();
    }

 */
}
