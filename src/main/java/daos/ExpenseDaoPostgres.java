package daos;

import entities.Employee;
import entities.Expense;
import entities.Status;
import entities.Type;
import utils.connectionUtil;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ExpenseDaoPostgres implements ExpenseDAO {


    @Override
    public Expense createExpense(Expense expense) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "Insert into expense values (default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, expense.getAmount());
            preparedStatement.setString(2, expense.getDescription());
            preparedStatement.setObject(3, expense.getStatus());
            preparedStatement.setObject(4,expense.getType());
            preparedStatement.execute();


            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("id");
            expense.setId(generatedKey);
            return expense;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Expense> getAllExpenses() {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from expense";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            Set<Expense> expenses = new HashSet<>();
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setAmount(rs.getInt("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(Status.PENDING); //Probably wrong
                expense.setType(Type.valueOf("Type")); //Absolutely wrong
                expenses.add(expense);
            }
            return expenses;

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }



    }

    @Override
    public Expense getExpenseId(int id) {
        try (Connection connnection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from expense where id = ?";
            PreparedStatement ps = connnection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Expense expense = new Expense();
            expense.setId(rs.getInt("id"));
            expense.setAmount(rs.getInt("amount"));
            expense.setDescription(rs.getString("description"));
            expense.setStatus(Status.PENDING); //Probably wrong
            expense.setType(Type.valueOf("Type")); //Absolutely wrong

            return expense;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Expense updateExpense(Expense expense) {
            try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
                String sql = "update expense set amount = ?, description = ?, Employee = ?, Status = ?, Type = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setInt(1, expense.getAmount());
                preparedStatement.setString(2, expense.getDescription());
                preparedStatement.setObject(3, expense.getStatus());
                preparedStatement.setObject(4,expense.getType());
                preparedStatement.setInt(5, expense.getId());
                preparedStatement.executeUpdate();

                return expense;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    @Override
    public boolean deleteExpenseById(int id) {
        try (Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "delete from expense where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public Expense expenseStatus(Status status) {
        return null;
    }

    @Override
    public Expense patchExpenseById(int id) {
        return null;
    }
}
