package daos;
//wisAnt
import entities.Expense;

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

}
