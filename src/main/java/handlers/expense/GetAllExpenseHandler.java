package handlers.expense;

import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
            Gson gson = new Gson();
            String json = gson.toJson(App.expenseService.getAllExpenses());
            ctx.result(json);
        }

    }

