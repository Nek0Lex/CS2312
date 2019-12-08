package Lab8.Q3_6;

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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void addSalary(int increase){
        salary += increase;
    }

    public void changeAnnualLeaves(int newAnnualLeaves) {
        annualLeaves = newAnnualLeaves;
    }

    public int getAnnualLeaves() {
        return annualLeaves;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " ($"+salary+", "+annualLeaves+" days)";
    }
}
