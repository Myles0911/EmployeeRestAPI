package entities;

import java.util.Objects;

public class Expense {
    //Employee id
    private int id;
    //amount of expense
    private int amount;
    private String description;
    //Status of expense
    private Status status;
    //Type of Status
    private Type type;


    public Expense() {

    }

    public Expense(int id, int amount, String description, Status status, Type type) {
        this.id = id;
        this.amount = amount;
        this.description = description;
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
        return id == expense.id && amount == expense.amount && description.equals(expense.description) && status == expense.status && type == expense.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, status, type);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}

