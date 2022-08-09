package app;

import daos.EmployeeDaoPostgres;
import daos.ExpenseDaoPostgres;
import daos.LocalExpenseDAO;
import handlers.employee.*;
import handlers.expense.*;
import io.javalin.Javalin;
import services.EmployeeService;
import services.EmployeeServiceImpl;
import services.ExpenseService;
import services.ExpenseServiceimpl;

public class App {
    public static ExpenseService expenseService = new ExpenseServiceimpl(new LocalExpenseDAO());
    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres()); //Update Employee and Get All are not functioning properly yet


    public static void main(String [] args) {
        Javalin app = Javalin.create();



            //Routes for Employee go here
            CreateEmployeeHandler createEmployeeHandler = new CreateEmployeeHandler();
            GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
            DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
            UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();
            GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();

           //Routes for Expense go here
        CreateExpenseHandler createExpenseHandler = new CreateExpenseHandler();
        GetSpecificExpenseHandler getSpecificExpenseHandler = new GetSpecificExpenseHandler();
        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();
        //PatchExpenseHandler patchExpenseHandler = new PatchExpenseHandler();
        GetAllExpenseHandler getAllExpenseHandler = new GetAllExpenseHandler();
        //GetExpenseStatusHandler getExpenseStatusHandler = new GetExpenseStatusHandler();


            //First Parameter route, second parameter is the functionality we want to call as that route is activated
            app.post("/employee", createEmployeeHandler);
            app.get("/employee/{id}", getEmployeeByIdHandler);
            app.get("/employee", getAllEmployeesHandler);
            app.delete("/employee/{id}", deleteEmployeeHandler);
            app.put("/employee/{id}", updateEmployeeHandler);


        app.post("/expense",createExpenseHandler);
        app.get("/expense ",getAllExpenseHandler);
      //  app.get("/expense?status=pending ", null);
        app.get("/expense/{id} ", getSpecificExpenseHandler);
        app.put("/expense/{id} ", updateExpenseHandler);
      //  app.patch("/expense/{id}/approve", null);
     //   app.patch("/expense/{id}/deny", null);
        app.delete("/expense/{id}", deleteExpenseHandler);


       // app.get("/employee/{id}/expense", null);
     //   app.post("/employee/{id}/expense", null);



            //Starts the Application
            app.start();
        }

}

