package Lab8.Q1;

public class AddSalary implements Command {

    @Override
    public void execute(String[] cmdParts) {
        Employee e;
        int addAmount;

        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        addAmount = Integer.parseInt(cmdParts[2]);

        e.addSalary(addAmount);
        System.out.println("Done.");
    }
}
