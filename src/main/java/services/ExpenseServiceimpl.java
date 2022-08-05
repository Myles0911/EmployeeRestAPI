package services;


import entities.Employee;
import entities.Expense;
import daos.ExpenseDAO;
import entities.Status;

import java.util.List;

public class ExpenseServiceimpl implements ExpenseService {

    private ExpenseDAO expenseDAO;

    public ExpenseServiceimpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @Override
    public Expense savedExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new RuntimeException(("The expense Cannot be negative"));
        }
        if (expense.getDescription().length() == 0) {
            throw new RuntimeException(("The Expense must have a description"));
        }
        Expense saveE = this.expenseDAO.createExpense(expense);
        return saveE;
    }



    @Override
    public Expense findExpenseByID(int id) {
        return this.expenseDAO.getExpenseId(id);
    }

    @Override
    public boolean deleteExpense(int id) {
      boolean success = this.expenseDAO.deleteExpenseById(id);
      return success;
    }

    @Override
    public Expense modExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new RuntimeException(("The expense Cannot be negative"));
        }
        if (expense.getDescription().length() == 0) {
            throw new RuntimeException(("The Expense must have a description"));
        }
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return (List<Expense>) this.expenseDAO.getAllExpenses();
    }



    @Override
    public Expense toEmployer(Employee employee) {
        return null;
    }

    @Override
    public Expense PendingStat(Status status) {
        return null;
    }
}

