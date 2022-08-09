package handlers.expense;

import app.App;
import com.google.gson.Gson;
import entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String exSon = ctx.body();
        Gson gson = new Gson();

        Expense expense = gson.fromJson(exSon, Expense.class);
        Expense updateExpense = App.expenseService.modExpense(expense);
        String json = gson.toJson(updateExpense);
        ctx.result(json);

    }
}
