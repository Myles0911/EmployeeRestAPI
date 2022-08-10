package services;


import entities.Employee;
import entities.Expense;
import daos.ExpenseDAO;
import entities.Status;

import java.util.List;
import java.util.Set;

public class ExpenseServiceimpl implements ExpenseService {

    private ExpenseDAO expenseDAO;

    public ExpenseServiceimpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @Override
    public Expense savedExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new RuntimeException(("The Expense amount cannot be negative"));
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
        if (expense.getAmount() == 0) {
            throw new RuntimeException(("There must be an expense"));
        }
        if (expense.getId() == 0) {
            throw new RuntimeException(("The Expense must have identification"));
        }
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public Set<Expense> getAllExpenses() {
        return this.expenseDAO.getAllExpenses();

    }

    @Override
    public Expense patchExpense(int id) {
        Expense ex1 = this.expenseStatus(Status.APPROVED);
        Expense ex2 = this.expenseStatus(Status.DENIED);
        if(expenseDAO.getExpenseId(id) == ex1) {
            this.approveExpense(id);
            return ex1;

        }else if(expenseDAO.getExpenseId(id) == ex2) {
            this.denyExpense(id);
        }
        return ex2;
    }

    @Override
    public Expense expenseStatus(Status status) {
        Status exStat = Status.PENDING;
        if(expenseStatus(status).getStatus() != Status.PENDING) {
            this.expenseDAO.updateExpense(expenseStatus(exStat));

        }
            Expense myStat = this.expenseDAO.expenseStatus(exStat);
        return  myStat;

    }

    @Override
    public boolean denyExpense(int id) {
        Expense expense = this.expenseDAO.getExpenseId(id);
        if (expense.getStatus() == Status.PENDING) {
            expense.setStatus(Status.DENIED);
            this.expenseDAO.updateExpense(expense);
            return true;
        } else if (expense.getStatus() != Status.PENDING) {
            throw new RuntimeException("The Status has already been APPROVED/DENIED");
        }
        return false;
    }

    @Override
    public boolean approveExpense(int id) {
        Expense expense = this.expenseDAO.getExpenseId(id);
        if (expense.getStatus() == Status.PENDING) {
            expense.setStatus(Status.APPROVED);
            this.expenseDAO.updateExpense(expense);
            return true;
        } else if (expense.getStatus() != Status.PENDING) {
            throw new RuntimeException("The Status had already been APPROVED/DENIED");
        }
        return false;
    }
}



