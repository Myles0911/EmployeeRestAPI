package app;

import daos.EmployeeDaoPostgres;
import daos.LocalExpenseDAO;
import handlers.*;
import daos.LocalEmployeeDAO;
import io.javalin.Javalin;
import services.EmployeeService;
import services.EmployeeServiceImpl;
import services.ExpenseService;
import services.ExpenseServiceimpl;

public class App {
    public static ExpenseService expenseService = new ExpenseServiceimpl(new LocalExpenseDAO());
    //public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres()); //Update Employee and Get All are not functioning properly yet
    public static EmployeeService employeeService = new EmployeeServiceImpl(new LocalEmployeeDAO());

    public static void main(String [] args) {
        Javalin app = Javalin.create();



            //Routes for Employee go here
            CreateEmployeeHandler createEmployeeHandler = new CreateEmployeeHandler();
            GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
            DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
            UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();
            GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();

            //Routes for Expense go here

            //First Parameter route, second parameter is the functionality we want to call as that route is activated
            app.post("/employee", createEmployeeHandler);
            app.get("/employee/{id}", getEmployeeByIdHandler);
            app.get("/employee", getAllEmployeesHandler);
            app.delete("/employee/{id}", deleteEmployeeHandler);
            app.put("/employee/{id}", updateEmployeeHandler);

/*
        app.post("/expense", null);
        app.get("/expense ",null);
        app.get("/expense?status=pending ", null);
        app.get("/expense/{id} ", null);
        app.put("/expense/{id} ", null);
        app.patch("/expense/{id}/approve", null);
        app.patch("/expense/{id}/deny", null);
        app.delete("/expense/{id}", null);


        app.get("/employees/{id}/expenses", null);
        app.post("/employee/{id}/expenes", null);
*/


            //Starts the Application
            app.start();
        }

}

