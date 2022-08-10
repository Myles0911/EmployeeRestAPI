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
        PatchExpenseHandler patchExpenseHandler = new PatchExpenseHandler();
        GetAllExpenseHandler getAllExpenseHandler = new GetAllExpenseHandler();
        //GetExpenseStatusHandler getExpenseStatusHandler = new GetExpenseStatusHandler();


            //First Parameter route, second parameter is the functionality we want to call as that route is activated
            app.post("/employees", createEmployeeHandler);
            app.get("/employees/{id}", getEmployeeByIdHandler);
            app.get("/employees", getAllEmployeesHandler);
            app.delete("/employees/{id}", deleteEmployeeHandler);
            app.put("/employees/{id}", updateEmployeeHandler);


        app.post("/expenses",createExpenseHandler);
        app.get("/expenses ",getAllExpenseHandler);
      //  app.get("/expenses?status=pending ", null);
        app.get("/expenses/{id} ", getSpecificExpenseHandler);
        app.put("/expenses/{id} ", updateExpenseHandler);
        app.patch("/expenses/{id}/approve", patchExpenseHandler);
        app.patch("/expenses/{id}/deny", patchExpenseHandler);
        app.delete("/expenses/{id}", deleteExpenseHandler);


       // app.get("/employee/{id}/expense", null);
     //   app.post("/employee/{id}/expense", null);



            //Starts the Application
            app.start();
        }

}

