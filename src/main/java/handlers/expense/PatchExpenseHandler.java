package handlers.expense;

import app.App;
import com.google.gson.Gson;
import entities.Expense;
import entities.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class PatchExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String status = ctx.queryParam("status");
        Gson gson = new Gson();
        if(status == null){
            Set<Expense> expenses = App.expenseService.getAllExpenses();
            String json = gson.toJson(expenses);
            ctx.result(json);
        }else{
            String status1 = status.toUpperCase();
            Set<Expense> expenses = (Set<Expense>) App.expenseService.expenseStatus(Status.valueOf(status1));
            String json = gson.toJson(expenses);
            ctx.result(json);
        }

    }
}
