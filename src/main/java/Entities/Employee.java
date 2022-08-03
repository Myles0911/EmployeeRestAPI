package Entities;

public class Employee {

    private int id;
    private String jobTitle;
    private String name;

    public Employee() {

    }

    public Employee(int id, String jobTitle, String name) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "employees{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
