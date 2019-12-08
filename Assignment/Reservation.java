public class Reservation implements Comparable<Reservation> {
    private String guestName, phoneNumber;
    private Day dateDine, dateRequest;
    private int totPersons;

     public Reservation(String guestName, String phoneNumber, int totPersons, String sDateDine){
         this.guestName = guestName;
         this.phoneNumber = phoneNumber;
         this.totPersons = totPersons;
         this.dateDine = new Day(sDateDine);
         this.dateRequest = SystemDate.getInstance().clone();
     }

    public static String getListingHeader()
    {
        return String.format("%-13s%-11s%-14s%-14s%s", "Guest Name", "Phone", "Request Date", "Dining Date", "#Persons");
    }

     @Override
    public String toString()
    {
        //Learn: "-" means left-aligned
        return String.format("%-13s%-11s%-14s%-14s%5d", guestName, phoneNumber, dateRequest, dateDine, totPersons);
    }

    public int compareTo(Reservation another) {
        return this.guestName.compareTo(another.guestName);
    }

}
