package Lab8.Q3_6;

public class ExchangeSalaries extends RecordedCommand {
    Employee e1, e2;
    int e1_salary, e2_salary;

    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        e1 = company.findEmployee(cmdParts[1]);
        e2 = company.findEmployee(cmdParts[2]);
        e1_salary = e1.getSalary();
        e2_salary = e2.getSalary();
        e1.setSalary(e2_salary);
        e2.setSalary(e1_salary);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        e1.setSalary(e1_salary);
        e2.setSalary(e2_salary);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e1.setSalary(e2_salary);
        e2.setSalary(e1_salary);
        addUndoCommand(this);
    }
}
