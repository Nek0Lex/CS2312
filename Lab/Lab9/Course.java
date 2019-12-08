import java.util.ArrayList;

public class Course {
    private String courseCode;
    private ArrayList<Offering> offerings;

    public Course(String courseCode) {
        this.courseCode = courseCode;
        this.offerings = new ArrayList<Offering>();
    }

    public void addOffering(String semId) {
        Offering o = new Offering(semId);
        this.offerings.add(o);
    }

    public Offering getOffering(String semId) {
        for (Offering o:
             offerings) {
            if (o.getSemId().equals(semId)){
                return o;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Offering o:
             offerings) {
            o.listStudents();
        }
    }
}
