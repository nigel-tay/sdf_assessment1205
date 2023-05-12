package task1;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Welcome.");

        double number1;
        double number2;
        String operator;
        double last = 0;
        double answer;

        String temp;
        String[] equation;
        
        Console cons = System.console();
        System.out.print("> ");

        while (!(temp = cons.readLine()).equals("exit")) {
            answer = 0.0;
            equation = temp.split(" ");
            operator = equation[1];

            if (equation[0].equals("$last") && equation[2].equals("$last")) {
                number1 = last;
                number2 = last;
                answer = evaluate(number1, number2, operator);
                last = answer;
            }
            else if (equation[0].equals("$last") || equation[2].equals("$last")) {
                switch(equation[0]) {
                    case "$last":
                        number1 = last;
                        number2 = Double.parseDouble(equation[2]);
                        break;
                    default:
                        number1 = Double.parseDouble(equation[0]);
                        number2 = last;
                        break;
                }
                answer = evaluate(number1, number2, operator);
                last = answer;
            }
            else {
                number1 = Double.parseDouble(equation[0]);
                number2 = Double.parseDouble(equation[2]);
                last = calculateLast(equation, last, number1, number2);
                answer = last;
            }
            String finalAnswer = answer % 1 == 0 
                ? String.format("%.0f", answer) 
                : String.format("%.1f", answer);
            System.out.println(finalAnswer);
            System.out.print("> ");
        }
        System.out.println("Bye bye");
    }

    public static double calculateLast(String[] equation, double last, double number1, double number2) {
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

    public static double evaluate(double number1, double number2, String operator) {
        double tempAnswer = 0.0;

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

        return tempAnswer;
    }

}
