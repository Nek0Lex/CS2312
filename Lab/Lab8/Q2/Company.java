package Lab8.Q2;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> allEmployees;

    private Company(){
        allEmployees = new ArrayList<Employee>();
    }

    public void listAllEmployee() {
        for (Employee allEmployee : allEmployees) {
            System.out.println(allEmployee.toString());
        }
    }

    public Employee findEmployee(String name){
        for (Employee allEmployee : allEmployees) {
            if (name.equals(allEmployee.getName())) {
                return allEmployee;
            }
        }
        return null;
    }

    public void addEmployee(Employee e){
        allEmployees.add(e);
    }

    private static Company instance = new Company();
    public static Company getInstance() {
        return instance;
    }
}
