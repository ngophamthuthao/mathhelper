import java.util.Scanner;

/**
 * An application to help young children practice their mathematics.  The application
 * will tailor arithmetic problems based on the competency of the user.  Command line
 * interaction allows the user to define the level of difficulty and then provide
 * answers to randomly generated problems.
 *
 * @author Your name, student number and FAN here
 */
public class MathsHelper {

    // IMPORTANT! This Scanner variable must remain public and non-final for code testing purposes
    public Scanner scan;

    private int yearLevel;
    private int numQuestions;
    private int quiz;

    public MathsHelper() {
        scan = new Scanner(System.in);
    }

    public int getQuiz() {
        return quiz;
    }
    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    /**
     * Performs one session of the Maths quiz
     */
    public void letsPlay() {
        displayWelcome();
        boolean confirmSessionDetails = false;
        while (!confirmSessionDetails) {
//            displayYearMenu();
//            yearLevel = scan.nextInt();
//            displayQuestionMenu();
//            numQuestions = scan.nextInt();
            displayYearMenu();
            yearLevel = scan.nextInt();
            while (yearLevel < 0 || yearLevel > 7) {
                displayYearMenu();
                yearLevel = scan.nextInt();
            }
            displayQuestionMenu();
            numQuestions = scan.nextInt();
            while (numQuestions < 1 || numQuestions > 5) {
                displayQuestionMenu();
                numQuestions = scan.nextInt();
            }
            confirmSessionDetails = confirmSessionDetails(yearLevel, numQuestions);
        }
        System.out.println("Let's begin ... (press 'Q' at any time to quit)");
//        QuestionGenerator quiz = new QuestionGenerator(yearLevel);
//        quiz.generateQuestions(numQuestions);
        askQuestion();
    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    private void displayWelcome() {
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|                      Welcome to the Maths Helper.                      |");
        System.out.println("|       Use this application to test your knowledge of mathematics.      |");
        System.out.println("|      This program is intended for children from reception to year 7    |");
        System.out.println("+------------------------------------------------------------------------+");
    }

    /**
     * Defines the Year Menu
     */
    private void displayYearMenu() {
        System.out.println("What is your year level? Choose an option from the list below:");
        System.out.println("+: addition, -: subtraction, *: multiplication, /: division, %: division with remainder");
        System.out.println("[0] Reception [+]");
        System.out.println("[1] Year 1 [+, -]");
        System.out.println("[2] Year 2 [+, -]");
        System.out.println("[3] Year 3 [+, -, *, /]");
        System.out.println("[4] Year 4 [+, -, *, /]");
        System.out.println("[5] Year 5 [+, -, *, /]");
        System.out.println("[6] Year 6 [+, -, *, /]");
        System.out.println("[7] Year 7 [+, -, *, /, %]");
    }

    /**
     * Defines the Question Menu
     */
    private void displayQuestionMenu() {
        System.out.println("How many questions would you like to attempt? Choose an option from the list below:");
        System.out.println("[1] 10 questions");
        System.out.println("[2] 20 questions");
        System.out.println("[3] 30 questions");
        System.out.println("[4] 40 questions");
        System.out.println("[5] 50 questions");
    }

    /**
     * Displays the confirmation message to the user and processes user input to
     * determine the accuracy of the information provided. If correct then
     * return true otherwise return false.
     *
     * @param year      the selected Year Menu item {0,1,2,3,4,5,6,7}
     * @param questions the selected Question Menu item {1,2,3,4,5}
     * @return boolean based on user's confirmation of correct data entry
     */
    public boolean confirmSessionDetails(int year, int questions) {
        String yearLevel = (year == 0) ? "Reception" : "Year " + year;
        String numQuestions = "";
        switch (questions) {
            case 1:
                numQuestions = "10";
                break;
            case 2:
                numQuestions = "20";
                break;
            case 3:
                numQuestions = "30";
                break;
            case 4:
                numQuestions = "40";
                break;
            case 5:
                numQuestions = "50";
                break;
            default:
                System.out.println("Invalid number of questions selected. Please try again.");
                break;
        }
        System.out.print("You are a " + yearLevel + " student and want to do " + numQuestions + " questions. Is this correct (Y/N)?: ");
//        String response = scan.nextLine();
        char response = scan.next().charAt(0);
        return response == 'Y' || response == 'y';
    }
    public void askQuestion() {
        int correctCount = 0;
        QuestionGenerator quiz = new QuestionGenerator(yearLevel);
        quiz.generateQuestions(numQuestions * 10);

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question question = quiz.getQuestions().get(i);

            // Present question
            System.out.println(question.getQuestion());

            // Get user's answer
            String userAnswer = scan.next();

            // Check user's answer
            if (userAnswer.equals(question.getAnswer())) {
                System.out.println("Correct! Well Done!");
                correctCount++;
            } else {
                System.out.println("Bad luck that was incorrect. The correct answer was " + question.getAnswer() + ".");
            }

            // Calculate and display current percentage
            double percentage = (double) correctCount / (i + 1) * 100;
            System.out.printf("Your current percentage is %.2f%%\n", percentage);
        }

        // Calculate and display total percentage
        double totalPercentage = (double) correctCount / quiz.getQuestions().size() * 100;
        System.out.printf("Your total percentage was %.2f%%\n", totalPercentage);

        // Print feedback based on total percentage
        if (totalPercentage < 40) {
            System.out.println("Bad luck. Try practicing with some lower year levels to build your confidence and skills.");
        } else if (totalPercentage < 50) {
            System.out.println("That was a good effort, but you may need to work on some expressions.");
        } else if (totalPercentage < 60) {
            System.out.println("Congratulations you passed. Keep practicing at this year level to improve your score.");
        } else if (totalPercentage < 75) {
            System.out.println("Well done. That was a good effort.");
        } else if (totalPercentage < 85) {
            System.out.println("Good job. You should try the next year level in your next test.");
        } else {
            System.out.println("Excellent work! You really know your stuff. Try the harder levels next time.");
        }
    }
}
