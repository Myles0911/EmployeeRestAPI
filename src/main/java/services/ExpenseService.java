package services;

import entities.Employee;
import entities.Expense;
import entities.Status;

import java.util.List;
import java.util.Set;

public interface ExpenseService {


    Expense savedExpense(Expense expense);

    Expense findExpenseByID(int id);

    boolean deleteExpense (int id);

    Expense modExpense (Expense expense);


    Set<Expense> getAllExpenses();

    Expense patchExpense (int id);

    Expense expenseStatus(Status status);

    boolean denyExpense(int id);

    boolean approveExpense(int id);



}
