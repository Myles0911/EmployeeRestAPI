package daotests;

import daos.EmployeeDAO;
import daos.EmployeeDaoPostgres;
import daos.LocalEmployeeDAO;
import entities.Employee;
import org.junit.jupiter.api.*;
import utils.connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTests {
    static EmployeeDAO employeeDAO = new EmployeeDaoPostgres();


 @BeforeAll // this method will execute before any tests ordered or unordered
    static void setup(){
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()){
            String sql = "create table employee(\n" +
                    "\tid serial primary key,\n" +
                    "\tjobTitle varchar(100) not null,\n" +
                    "\tname varchar(100) not null,\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }




    @Test
    @Order(1)
    void create_employee_test() {
        Employee employee = new Employee(0, "Java Developer", "Myles Walker");
        Employee savedEmployee = employeeDAO.createEmployee(employee);
        Assertions.assertNotEquals(0, savedEmployee.getId());
        System.out.println(employee);
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
        Employee employee2 = new Employee(1, "Software Engineer", "Emile Lyonhelm");
       employeeDAO.updateEmployee(employee2);
        Employee employee = employeeDAO.getEmployeeById(1);
        Assertions.assertEquals("Software Engineer", employee.getJobTitle());


    }

    @Test
    @Order(4)
    void delete_employee_by_id_test() {
        boolean result = employeeDAO.deleteEmployeeById(1);
        Assertions.assertTrue(result);
    }

  //  @AfterAll // runs after the last test finishes
//    static void teardown(){
//
//        try(Connection connection = ConnectionUtil.createConnection()){
//            String sql = "drop table book";
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }

}




