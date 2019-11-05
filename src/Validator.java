import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public Validator() {
    }

    public boolean isValidCourse(Transcript transcript, String courseCode) {

        for (CourseEnrollment course : transcript.getCourses()) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValid(long longValue, long min, long max) {
        if (longValue < min)
            return false;
        else if (longValue > max)
            return false;
        else
            return true;
    }

    public boolean isValid(int intValue, int min, int max) {
        return isValid((long) intValue, (long) min, (long) max);
    }

    public boolean isValid(String input, String expression) {

        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        return (matcher.matches());

    }
}
