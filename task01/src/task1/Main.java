package task1;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Welcome.");

        int number1;
        int number2;
        String operator;
        int last = 0;
        String answer;

        String temp;
        String[] equation;
        
        Console cons = System.console();
        System.out.print("> ");

        while (!(temp = cons.readLine()).equals("exit")) {
            answer = "";
            equation = temp.split(" ");

            if (equation[0].equals("$last") || equation[2].equals("$last")) {
                operator = equation[1];
                switch(equation[0]) {
                    case "$last":
                        number1 = last;
                        number2 = Integer.parseInt(equation[2]);
                        break;
                    default:
                        number1 = Integer.parseInt(equation[0]);
                        number2 = last;
                        break;
                }
                answer = evaluate(number1, number2, operator);
                last = Integer.parseInt(answer);
            }
            else {
                operator = equation[1];
                number1 = Integer.parseInt(equation[0]);
                number2 = Integer.parseInt(equation[2]);
                last = calculateLast(equation, last, number1, number2);
                answer = Integer.toString(last);
            }
            System.out.println(answer);
            System.out.print("> ");
        }
    }

    public static int calculateLast(String[] equation, int last, int number1, int number2) {
        switch(equation[1]) {
            case "+":
                last = number1 + number2;
                break;
            case "-":
                last = number1 - number2;
                break;
            case "/":
                last = number1 / number2;
                break;
            case "*":
                last = number1 * number2;
                break;
            default:
                System.out.println("Please give an appropriate operator. (e.g. '+', '-', '/', '*')");
        }

        return last;
    }

    public static String evaluate(int number1, int number2, String operator) {
        int tempAnswer = 0;

        switch(operator) {
            case "+":
                tempAnswer = number1 + number2;
                break;
            case "-":
                tempAnswer = number1 - number2;
                break;
            case "/":
                tempAnswer = number1 / number2;
                break;
            case "*":
                tempAnswer = number1 * number2;
                break;
        }

        return Integer.toString(tempAnswer);
    }

}
