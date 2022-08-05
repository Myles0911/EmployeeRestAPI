package daos;

import entities.Expense;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class LocalExpenseDAO implements  ExpenseDAO {
    private final Map<Integer, Expense> expenseTable = new HashMap<Integer, Expense>();
    private int idCounter = 1;

    @Override
    public Expense createExpense(Expense expense) {
        expense.setId(idCounter);
        idCounter++;
        expenseTable.put(expense.getId(), expense);
        System.out.println(expenseTable.values());
        return expense;

    }

    @Override
    public Set<Expense> getAllExpenses() {
        Set<Expense> expenses = new HashSet<Expense>(this.expenseTable.values());
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
}
