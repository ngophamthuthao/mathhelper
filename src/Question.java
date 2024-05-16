import java.util.Random;

public class Question {
    private String question;
    private String answer;

    public Question(int min, int max, char[] operations) {
        Random rand = new Random();
        int value1 = rand.nextInt(max - min + 1) + min;
        int value2 = rand.nextInt(max - min + 1) + min;
        char operation = operations[rand.nextInt(operations.length)];
        if (operation == '/' || operation == '%') {
            while (value2 == 0) {
                value2 = rand.nextInt(max - min + 1) + min;
            }
            if (operation == '/') {
                int result = (int) Math.round((double)value1 / value2);
                answer = String.valueOf(result);
            } else {
                int result = value1 / value2;
                int remainder = value1 % value2;
                answer = result + "r" + remainder;
            }

        } else {
            int result = 0;
            switch (operation) {
                case '+':
                    result = value1 + value2;
                    break;
                case '-':
                    result = value1 - value2;
                    break;
                case '*':
                    result = value1 * value2;
                    break;
            }
            answer = String.valueOf(result);
        }

        question = value1 + " " + operation + " " + value2 + " = ";
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }

}
