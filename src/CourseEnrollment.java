public class CourseEnrollment {

    private String courseCode;
    private Integer credits;
    private String grade;

    public CourseEnrollment() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getQualityPoint() {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
        }

        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%-20s %7d %7s %10.2f", courseCode, credits, grade, getQualityPoint());

    }
}
