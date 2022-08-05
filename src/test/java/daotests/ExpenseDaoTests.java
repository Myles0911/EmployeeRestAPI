package daotests;

import entities.Employee;
import entities.Expense;
import daos.ExpenseDAO;
import daos.LocalExpenseDAO;
import entities.Status;
import entities.Type;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseDaoTests {


    static ExpenseDAO expenseDAO = new LocalExpenseDAO();

/*
 @BeforeAll // this method will execute before any tests ordered or unordered
    static void setup(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table book(\n" +
                    "\tid serial primary key,\n" +
                    "\ttitle varchar(100) not null,\n" +
                    "\tauthor varchar(100) not null,\n" +
                    "\treturn_date int default 0\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

 */


    @Test
    @Order(1)
    void create_expense_Test() {
        Expense expense = new Expense(0, 0, "Getting Groceries", new Employee(), Status.APPROVED, Type.FOOD);
        Expense savedExpense = expenseDAO.createExpense(expense);
        Assertions.assertEquals(0, savedExpense.getId());
        System.out.println(expense);
    }

    @Test
    @Order(2)
    void get_expense_by_id_test() {
        Expense expense = expenseDAO.getExpenseId(1);
        Assertions.assertEquals("Getting Groceries", expense.getDescription());
    }

    @Test
    @Order(3)
    void updated_expense_Test() {
        Expense expense2 = new Expense(1, 1, "Traveling to Spain", new Employee(), Status.DENIED, Type.TRAVEL);
        expenseDAO.updateExpense(expense2);
        Expense expense = expenseDAO.getExpenseId(1);
        Assertions.assertEquals("Traveling to Spain", expense.getDescription());
    }

    @Test
    @Order(3)
    void delete_expense_by_id_test() {
        boolean result = expenseDAO.deleteExpenseById(1);
        Assertions.assertTrue(result);
    }

    @Test
    @Order(3)
    void get_all_expenses_test() {
    Expense expenseMK1 = new Expense(0, 0, "Traveling to France", new Employee(), Status.APPROVED, Type.LODGING);
    Expense expenseMK2 = new Expense(3, 6, "Purchasing foodstuffs", new Employee(), Status.PENDING, Type.FOOD);
    Expense expenseMK3 = new Expense(0, 5, "Injury", new Employee(), Status.APPROVED, Type.MISC);

    expenseDAO.createExpense(expenseMK1);
        expenseDAO.createExpense(expenseMK2);
        expenseDAO.createExpense(expenseMK3);

        List<Expense> expenseList = (List<Expense>) expenseDAO.getAllExpenses(); //Might be wrong
        Assertions.assertEquals(3,expenseList.size());
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
