import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {
    private int min;
    private int max;
    private char[] operations;
    private List<Question> questions = new ArrayList<>();

    public QuestionGenerator(int year) {
        this.min = findMin(year);
        this.max = findMax(year);
        this.operations = findOperations(year);
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public char[] getOperations() {
        return operations;
    }
    public void setOperations(char[] operations) {
        this.operations = operations;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public static int findMin(int year) {
        if (year == 7) {
            return -9999;
        } else if (year >= 5 && year <= 6) {
            return -999;
        } else {
            return 0;
        }

    }
    public static int findMax(int year) {
        if (year == 7) {
            return 9999;
        } else if (year >= 5 && year <= 6) {
            return 999;
        } else if (year >= 3 && year <= 4) {
            return 99;
        } else {
            return 9;
        }
    }
    public static char[] findOperations(int year) {
        if (year == 7) {
            return new char[]{'+', '-', '*', '/', '%'};
        } else if (year >= 3 && year <= 6) {
            return new char[]{'+', '-', '*', '/'};
        } else if (year == 1 || year == 2) {
            return new char[]{'+', '-'};
        } else {
            return new char[]{'+'};
        }
    }
    public void generateQuestions(int num) {
        for (int i = 0; i < num; i++) {
            questions.add(new Question(min, max, operations));
        }
    }

}
