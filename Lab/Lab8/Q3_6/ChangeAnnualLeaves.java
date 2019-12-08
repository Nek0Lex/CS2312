package Lab8.Q3_6;

public class ChangeAnnualLeaves extends RecordedCommand {
    Employee e;
    int newAnnualLeaves, prevAnnualLeaves;

    @Override
    public void execute(String[] cmdParts) {
        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        prevAnnualLeaves = e.getAnnualLeaves();
        newAnnualLeaves = Integer.parseInt(cmdParts[2]);

        e.changeAnnualLeaves(newAnnualLeaves);
        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        e.changeAnnualLeaves(prevAnnualLeaves);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e.changeAnnualLeaves(newAnnualLeaves);
        addUndoCommand(this);
    }

}
