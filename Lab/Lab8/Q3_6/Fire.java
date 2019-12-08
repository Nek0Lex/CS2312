package Lab8.Q3_6;

public class Fire extends RecordedCommand {
    Employee e;
    String e_name;
    Company company = Company.getInstance();

    @Override
    public void execute(String[] cmdParts) {
//        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        company.fireEmployee(e);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        company.addEmployee(e);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        company.fireEmployee(e);
        addUndoCommand(this);
    }
}
