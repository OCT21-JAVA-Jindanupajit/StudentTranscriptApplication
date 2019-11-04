import java.util.ArrayList;

public class Transcript {
    private long id;
    private String firstName;
    private String lastName;

    private final ArrayList<CourseEnrollment> courses =  new ArrayList<>();

    public Transcript() {
    }

    public void addCourse(CourseEnrollment course) {

        //TODO: public void addCourse(CourseEnrollment course)
    }

    public double getOverallGPA() {
        //TODO: public double getOverallGPA()
        return 0;
    }

    public String getFormattedGPA() {
        //TODO: public String getFormattedGPA()
        return "";
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return courses;
    }

//    public void setCourseEnrollment(ArrayList<CourseEnrollment> courseEnrollment) {
//        this.courseEnrollment = courseEnrollment;
//    }
}
