package Handlers;

import Entities.Employee;
import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.GenericSignatureFormatError;

public class UpdateEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String empJson = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(empJson, Employee.class);
        Employee updateEmployee = App.employeeService.modEmployee(employee);
        String json = gson.toJson(updateEmployee);

            ctx.result(json);

        }
    }

