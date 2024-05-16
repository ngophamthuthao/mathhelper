/*6*
 * Driver program for the MathsHelper class
 *
 * @author Your name, student number and FAN here
 */
public class MathsHelperDriver {

    /**
     * main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      Task 1:
        new MathsHelper().letsPlay();

//      Task 2:
        System.out.println(QuestionGenerator.findMin(3));
        System.out.println(QuestionGenerator.findMax(5));
        System.out.println(QuestionGenerator.findOperations(6));

        QuestionGenerator quiz1 = new QuestionGenerator(3);
        QuestionGenerator quiz2 = new QuestionGenerator(7);
        System.out.println(quiz1.getMin());
        System.out.println(quiz1.getMax());
        System.out.println(quiz1.getOperations());
        System.out.println(quiz2.getMin());
        System.out.println(quiz2.getMax());
        System.out.println(quiz2.getOperations());

//      Task 3:
        Question question1 = new Question(0, 100, new char[]{'+','-'});
        Question question2 = new Question(-30, -5, new char[]{'*','/'});
        Question question3 = new Question(200, 1000, new char[]{'%'});

        System.out.println(question1.getQuestion());
        System.out.println(question1.getAnswer());
        System.out.println(question2.getQuestion());
        System.out.println(question2.getAnswer());
        System.out.println(question3.getQuestion());
        System.out.println(question3.getAnswer());

        QuestionGenerator quiz3 = new QuestionGenerator(0);
        quiz3.generateQuestions(5);
        System.out.println(quiz3.getQuestions());

//      Task 4:
        new MathsHelper().letsPlay();

    }

}
