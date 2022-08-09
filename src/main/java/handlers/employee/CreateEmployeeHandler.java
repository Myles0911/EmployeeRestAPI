package handlers.employee;

import entities.Employee;
import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        Employee newEmployee = App.employeeService.signOnEmployee(employee);
        String empSon = gson.toJson(newEmployee);
        ctx.status(201);
        ctx.result(empSon);

    }
}
