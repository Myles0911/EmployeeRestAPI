package handlers.expense;

import app.App;
import com.google.gson.Gson;
import entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(json, Expense.class);
        Expense getNewExpense = App.expenseService.savedExpense(expense);
        String expenseJson = gson.toJson(getNewExpense);
        ctx.status(201);
        ctx.result(expenseJson);

    }
}
