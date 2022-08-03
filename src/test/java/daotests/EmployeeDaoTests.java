package daotests;

import daos.EmployeeDAO;
import daos.LocalEmployeeDAO;
import Entities.Employee;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTests {
    static EmployeeDAO employeeDAO = new LocalEmployeeDAO();

    @Test
    @Order(1)
    void create_employee_test() {
        Employee employee = new Employee(0, "Java Developer", "Myles Walker");
        Employee thisEmployee = employeeDAO.createEmployee(employee);
        Assertions.assertEquals(0, thisEmployee.getId() );
    }

    @Test
    @Order(2)
    void get_employee_By_id_test() {
        Employee employee = employeeDAO.getEmployeeById(1);
        Assertions.assertEquals("Java Developer", employee.getJobTitle());

    }

    @Test
    @Order(3)
    void update_employee_test() {
        Employee myE = new Employee( 1, "Revachure Engineer", "Miles Walker");
        employeeDAO.updateEmployee(myE);
        Employee employee = employeeDAO.getEmployeeById(1);
        Assertions.assertEquals("Revachure Engineer", employee.getJobTitle());


    }

    @Test
    @Order(4)
    void delete_employee_by_id_test() {
        boolean result = employeeDAO.deleteEmployeeById(1);
        Assertions.assertTrue(result);
    }



}
