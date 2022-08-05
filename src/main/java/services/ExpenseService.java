package services;

import entities.Employee;
import entities.Expense;
import entities.Status;

import java.util.List;

public interface ExpenseService {


    Expense savedExpense(Expense expense);

    Expense findExpenseByID(int id);

    boolean deleteExpense (int id);

    Expense modExpense (Expense expense);

    List<Expense> getAllExpenses();



    Expense toEmployer(Employee employee);

    Expense PendingStat (Status status);



}
