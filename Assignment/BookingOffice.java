import java.util.ArrayList;
import java.util.Collections;

public class BookingOffice{
    private ArrayList<Reservation> allReservations;
    private static BookingOffice instance = new BookingOffice();


    public static BookingOffice getInstance() {
        return instance;
    }

    public BookingOffice(){
        allReservations = new ArrayList<>();
    }

    public Reservation addReservation(String guestName, String phoneNumber, int totPersons, String sDateDine)  // See how it is called in main() in P.1
    {
        Reservation r = new Reservation(guestName, phoneNumber, totPersons, sDateDine);
        allReservations.add(r);
        Collections.sort(allReservations); // allReservations

        return r; //Why return?  Ans: You'll see that it is useful in CmdRequest.java in Q2.
    }

    public void listReservations() {
        System.out.println(Reservation.getListingHeader()); // Reservation
        for (Reservation r : allReservations)
            System.out.println(r.toString()); // r or r.toString()
    }

    public void removeReservation(Reservation r){
        allReservations.remove(r);
    }

    public void addReservation(Reservation r){
        allReservations.add(r);
        Collections.sort(allReservations);
    }


}
