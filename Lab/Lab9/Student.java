import java.util.ArrayList;

public class Student {
    private String studentId;
    private ArrayList<Offering> studies;

    public Student(String studentId) {
        this.studentId = studentId;
        studies = new ArrayList<>();
    }

    public void takeCourse(Course course, String semId) {
        Offering o = course.getOffering(semId);
        this.studies.add(o);
        o.addStudent(this);
    }

    public boolean hasBeenClassmateOf(Student s2) {
        for (Offering o:
             studies) {
            if (s2.hasTaken(o)){
                return true;
            }
        }
        return false;
    }

    private boolean hasTaken(Offering target) {
        for (Offering o:
             this.studies) {
            if (o == target){
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return studentId;
    }

}
