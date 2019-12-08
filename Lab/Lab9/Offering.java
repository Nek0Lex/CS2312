import java.util.ArrayList;

public class Offering {

    private String semId;
    private ArrayList<Student> students;

    public Offering(String semId){
        this.semId = semId;
        students = new ArrayList<>();
    }

    public String getSemId() {
        return semId;
    }

    public void listStudents() {
        String result = semId + ": ";
        for (Student s:
             this.students) {
            result += s.getId() + " ";
        }
        System.out.println(result);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
