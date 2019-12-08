public class CmdRequest extends RecordedCommand {
    Reservation r;
    BookingOffice bo;
    @Override
    public void execute(String[] cmdParts) {
        bo = BookingOffice.getInstance();
        String guestName = cmdParts[1];
        String phoneNumber = cmdParts[2];
        int totPersons = Integer.parseInt(cmdParts[3]);
        String sDateDine = cmdParts[4];
        r = bo.addReservation(guestName, phoneNumber, totPersons, sDateDine);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        bo.removeReservation(r);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        bo.addReservation(r);
        addUndoCommand(this);
    }
}
