package daos;

import entities.Employee;
import entities.Expense;
import entities.Status;
import entities.Type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class LocalExpenseDAO implements  ExpenseDAO {
    private final Map<Integer, Expense> expenseTable = new HashMap<Integer, Expense>();
    private int idCounter = 0;

    @Override
    public Expense createExpense(Expense expense) {
        expense.setId(++this.idCounter);
        expenseTable.put(this.idCounter, expense);
        return expense;

    }

    @Override
    public Set<Expense> getAllExpenses() {
        Set<Expense> expenses = new HashSet<>(this.expenseTable.values());
        return expenses;
    }

    @Override
    public Expense getExpenseId(int id) {
        Expense expense = this.expenseTable.get(id);
        return expense;
    }

    @Override
    public Expense updateExpense(Expense expense) {
        this.expenseTable.put(expense.getId(), expense);
        return expense;
    }

    @Override
    public boolean deleteExpenseById(int id) {
        Expense expense = expenseTable.remove(id);
        return expense != null;
    }

    @Override
    public Expense patchExpenseById(int id) {
        Expense expense = this.expenseTable.get(id);
        if (expense == expenseStatus(Status.valueOf("PENDING"))) {

            return expense;
        }
        return expense;
    }


    @Override
    public Expense expenseStatus(Status status) {
       Expense expense = expenseStatus(Status.valueOf("PENDING"));
     return expense;
    }
}
