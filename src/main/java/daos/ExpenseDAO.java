package daos;
//wisAnt
import entities.Employee;
import entities.Expense;
import entities.Status;
import entities.Type;

import java.util.Set;

public interface ExpenseDAO {
    //create
    Expense createExpense (Expense expense);


    //Read
    Set<Expense> getAllExpenses();
    Expense getExpenseId(int id);

    //Update
    Expense updateExpense(Expense expense);


    //Delete
    boolean deleteExpenseById(int id);

    //Patch
    Expense patchExpenseById(int id);


    //Get Expense Status
    Expense expenseStatus(Status status);








}
