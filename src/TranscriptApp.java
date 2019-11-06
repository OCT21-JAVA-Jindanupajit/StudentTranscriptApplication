import lang.JaVALOR.utils.ConsoleMenu.ConsoleMenu;
import lang.JaVALOR.utils.KeyboardScanner.KeyboardScanner;

public class TranscriptApp {

    private static Validator validator = new Validator();

    public static void main(String[] args) {


        System.out.println(inputTranscript());

    }

    private static Transcript inputTranscript() {
        KeyboardScanner keyboardScanner = new KeyboardScanner();
        Transcript transcript = new Transcript();

        transcript.setId(Long.parseLong(keyboardScanner.getToken("Enter Student ID number: ")));
        transcript.setFirstName(keyboardScanner.getLine("Enter Student's first name: "));
        transcript.setLastName(keyboardScanner.getLine("Enter Student's last name: "));

        System.out.println("");

        whileLoop:
        while(true) {
            transcript.addCourse(inputCourseEnrollment(transcript));

            switch (keyboardScanner.getToken("Another course? (y/n): ").toLowerCase()) {
                case "y":
                case "yes":
                        continue whileLoop;

                case "n":
                case "no":
                        break whileLoop;
            }

            System.out.println(" * please answer \"y\" or \"n\"!");
        }

        return transcript;
    }

    private static CourseEnrollment inputCourseEnrollment(Transcript transcript) {
        KeyboardScanner kb = new KeyboardScanner();
        CourseEnrollment courseEnrollment = new CourseEnrollment();

        String userInput;

        while (true) {
            userInput = kb.getToken("Enter course: ");

            if (validator.isValidCourse(transcript, userInput))
                System.out.println(" * Duplicate!, try again.");
            else
                break;
        }
        courseEnrollment.setCourseCode(userInput);

        int credit = 0;
        while (true) {
            userInput = kb.getToken("Enter credits: ");

            try {
                credit = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println(" * Not a number!, try again.");
                continue;
            }

            if (validator.isValid(credit, 0, 5))
                break;
            else
                System.out.println(" * Enter 0 - 5 only");
        }
        courseEnrollment.setCredits(credit);

        String grade = "";
        while (true) {
            grade = kb.getToken("Enter grade: ").toUpperCase();
            if (validator.isValid(grade.toUpperCase(),"^[ABCDF]$"))
                break;
            else
                System.out.println(" * Enter 'A', 'B', 'C', 'D', or 'F' only");
        }
        courseEnrollment.setGrade(grade);

        return courseEnrollment;
    }
}
