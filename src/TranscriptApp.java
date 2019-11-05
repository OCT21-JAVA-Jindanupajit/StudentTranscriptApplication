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
                System.out.println("Duplicate!, try again.");
            else
                break;
        }
        courseEnrollment.setCourseCode(userInput);

        while (true) {
            userInput = kb.getToken("Enter credits: ");

                try {
                    Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    System.out.println("Not a number!, try again.");
                    //e.printStackTrace();
                }
                //TODO: !!!

        }
        courseEnrollment.setCredits();


        courseEnrollment.setGrade(kb.getToken("Enter grade: "));

        return courseEnrollment;
    }
}
