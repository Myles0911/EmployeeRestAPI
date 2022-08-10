package daotests;

import entities.Employee;
import entities.Expense;
import daos.ExpenseDAO;
import daos.LocalExpenseDAO;
import entities.Status;
import entities.Type;
import org.junit.jupiter.api.*;
import utils.connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseDaoTests {


    static ExpenseDAO expenseDAO = new LocalExpenseDAO();


 @BeforeAll // this method will execute before any tests ordered or unordered
    static void setup(){
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()){
            String sql = "create table expense(\n" +
                    "\tid serial primary key,\n" +
                    "\tamount int,\n" +
                    "\tdescription varchar(100),\n" +
                    "\tstatus Varchar(100),\n" +
                    "\ttype Varchar(100)\n" +
                    ";\n";

            Statement statement = conn.createStatement();
            statement.execute(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }




    @Test
    @Order(1)
    void create_expense_Test() {
        Expense expense = new Expense(1, 500, "Getting Groceries", Status.APPROVED, Type.FOOD);
        Expense savedExpense = expenseDAO.createExpense(expense);
        Assertions.assertEquals(1, savedExpense.getId());
        System.out.println(expense);
    }

    @Test
    @Order(2)
    void get_expense_by_id_test() {
        Expense expense = expenseDAO.getExpenseId(0);
        Assertions.assertEquals("Getting Groceries", expense.getDescription());
    }

    @Test
    @Order(3)
    void updated_expense_Test() {
        Expense expense2 = new Expense(1, 2500, "Flight to Spain", Status.DENIED, Type.TRAVEL);
        expenseDAO.updateExpense(expense2);
        Expense expense = expenseDAO.getExpenseId(1);
        Assertions.assertEquals("Flight to Spain", expense.getDescription());
    }

    @Test
    @Order(3)
    void delete_expense_by_id_test() {
        boolean result = expenseDAO.deleteExpenseById(1);
        Assertions.assertTrue(result);
    }

    @Test
    @Order(4)
    void get_all_expenses_test() {
    Expense expenseMK1 = new Expense(0, 0, "Traveling to France", Status.APPROVED, Type.LODGING);
    Expense expenseMK2 = new Expense(3, 6, "Purchasing foodstuffs", Status.PENDING, Type.FOOD);
    Expense expenseMK3 = new Expense(0, 5, "Injury", Status.APPROVED, Type.MISC);

    expenseDAO.createExpense(expenseMK1);
        expenseDAO.createExpense(expenseMK2);
        expenseDAO.createExpense(expenseMK3);

        Set<Expense> expenses = (Set<Expense>) expenseDAO.getAllExpenses(); //Might be wrong
        Assertions.assertEquals(3,expenses.size());
    }
    //    @AfterAll // runs after the last test finishes
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
