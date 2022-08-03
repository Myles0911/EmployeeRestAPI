package app;

import Handlers.*;
import daos.LocalEmployeeDAO;
import io.javalin.Javalin;
import services.EmployeeService;
import services.EmployeeServiceImpl;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new LocalEmployeeDAO());

    public static void main(String [] args) {
        Javalin app = Javalin.create();

        //Routes for Employee go here
        CreateEmployeeHandler createEmployeeHandler = new CreateEmployeeHandler();
        GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
        DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
        UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();
        GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();

        //First Parameter route, second parameter is the functionality we want to call as that route is activated
        app.post("/employee", createEmployeeHandler);
        app.get("/employee/{id}", getEmployeeByIdHandler);
        app.get("/employee", getAllEmployeesHandler);
        app.delete("/employee/{id}", deleteEmployeeHandler);
        app.put("/employee/{id}", updateEmployeeHandler);


        //Routes for Expense go here


        //Starts the Application
        app.start();
    }
}
