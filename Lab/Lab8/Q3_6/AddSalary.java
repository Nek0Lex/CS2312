package Lab8.Q3_6;

public class AddSalary extends RecordedCommand {
    Employee e;
    int addAmount;

    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        addAmount = Integer.parseInt(cmdParts[2]);

        e.addSalary(addAmount);
        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        e.addSalary(-addAmount);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e.addSalary(addAmount);
        addUndoCommand(this);
    }
}
