package daos;

import entities.Employee;
import utils.connectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDaoPostgres implements EmployeeDAO {


    @Override
    public Employee createEmployee(Employee employee) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "insert into employee values (default, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getJobTitle());
            preparedStatement.setString(2, employee.getName());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedkey = rs.getInt("id");
            employee.setId(generatedkey);
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from employee ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            Set<Employee> employees = new HashSet<Employee>();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setJobTitle(rs.getString("jobTitle"));
                employee.setName(rs.getString("name"));
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = " select * from employee where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setJobTitle(rs.getString("jobTitle"));
            employee.setName(rs.getString("name"));

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "update employee set jobTitle = ?, name = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, employee.getJobTitle());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getId());
            return employee;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "delete from employee where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
