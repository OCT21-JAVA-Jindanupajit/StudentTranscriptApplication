import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Transcript {
    private long id;
    private String firstName;
    private String lastName;

    private final ArrayList<CourseEnrollment> courses =  new ArrayList<>();

    private Validator validator = new Validator();

    public Transcript() {
    }

    public void addCourse(CourseEnrollment course) {

        if (validator.isValidCourse(this, course.getCourseCode()))
            return; // Duplicate

        courses.add(course);
    }

    public double getOverallGPA() {
        int courseCounter = 0;
        double allQualityPoint = 0;
        for (CourseEnrollment courseEnrollment : courses) {
            courseCounter++;
            allQualityPoint += courseEnrollment.getQualityPoint();
        }

        return (courseCounter>0)?allQualityPoint/courseCounter:0;
    }

    public String getFormattedGPA() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        return df.format(getOverallGPA());
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

//    Read only
//    public void setCourseEnrollment(ArrayList<CourseEnrollment> courseEnrollment) {
//        this.courseEnrollment = courseEnrollment;
//    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb  .append("\n").append(firstName).append(" ").append(lastName).append("\n")
            .append("Student ID: ").append(id).append("\n\n");
        sb  .append(String.format("%-20s %7s %7s %20s\n", "Course", "Credit", "Grade", "Quality Points"));
        sb  .append("==================== ======= ======= ====================\n");
        for (CourseEnrollment course : courses) {
            sb.append(course).append("\n");


        }

        sb.append("\nGPA: ").append(getFormattedGPA()).append("\n\n");

        return sb.toString();
    }
}
