package handlers.employee;

import entities.Employee;
import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEmployeeByIdHandler implements Handler {


    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = App.employeeService.getEmployeeByID(id);
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        ctx.result(json);
    }
}
