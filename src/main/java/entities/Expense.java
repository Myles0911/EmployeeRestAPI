package entities;

import java.util.Objects;

public class Expense {

    private int id;
    private int amount;
    private String description;
    //Who is making the expense
    private Employee employee;

    //Status of expense
    private Status status;

    //Type of Expense

    //Type of Status
    private Type type;

public Expense () {

}

    public Expense(int id, int amount, String description, Employee employee, Status status, Type type) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.employee = employee;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return id == expense.id && amount == expense.amount && Objects.equals(description, expense.description) && Objects.equals(employee, expense.employee) && status == expense.status && type == expense.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, employee, status, type);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}


