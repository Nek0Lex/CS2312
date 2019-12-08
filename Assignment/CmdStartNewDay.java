public class CmdStartNewDay extends RecordedCommand {
    String prevDate, newDate;

    @Override
    public void execute(String[] cmdParts) {
        prevDate = SystemDate.getInstance().clone().toString();
        newDate = cmdParts[1];
        SystemDate.getInstance().set(newDate);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        SystemDate.getInstance().set(prevDate);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        SystemDate.getInstance().set(newDate);
        addUndoCommand(this);
    }
}
