package Lab8.Q3_6;
public class ListAllRecords implements Command {
    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        company.listAllEmployee();
    }
}
