package Entities;

public class Expense {

    private int id;
    private int amount;
    private String description;
    //Who is making the expense
    private Employee employee;

    //Status of expense
    private String Status;

    //Type of Expense

    //Type of Status
    private String Type;

public Expense () {

}

    public Expense(int id, int amount, String description, Employee employee, String status, String type) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.employee = employee;
        Status = status;
        Type = type;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }



    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                ", Status='" + Status + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}


