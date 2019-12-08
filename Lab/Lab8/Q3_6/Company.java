package Lab8.Q3_6;
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

    public void fireEmployee(Employee e) {
        for (int i = 0; i < allEmployees.size(); i++) {
            if (allEmployees.get(i).equals(e)){
                allEmployees.remove(i);
            }
        }
    }

    private static Company instance = new Company();
    public static Company getInstance() {
        return instance;
    }
}
