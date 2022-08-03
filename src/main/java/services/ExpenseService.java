package services;

import Entities.Expense;

import java.awt.print.Book;

public interface ExpenseService {


    Expense saveExpense(Expense expense);

    Expense findExpenseByID(int id);

    boolean deleteExpense (int id);

    Book modExpense (Expense expense);


}
