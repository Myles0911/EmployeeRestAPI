package handlers.expense;

import app.App;
import com.google.gson.Gson;
import entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetSpecificExpenseHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Expense expense = App.expenseService.findExpenseByID(id);
        Gson gson = new Gson();
        String json = gson.toJson(expense);
        ctx.result(json);
    }
}
