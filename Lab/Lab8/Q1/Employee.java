package Lab8.Q1;

public class Employee {
    private String name;
    private int salary, annualLeaves;

    public Employee(String name, int salary, int annualLeaves){
        this.name = name;
        this.salary = salary;
        this.annualLeaves = annualLeaves;
    }

    public String getName() {
        return name;
    }

    public void addSalary(int increase){
        salary += increase;
    }

    @Override
    public String toString() {
        return name + " ($"+salary+", "+annualLeaves+" days)";
    }
}
