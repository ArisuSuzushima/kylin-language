package Program;

import java.util.Arrays;
import java.util.Stack;

public class StringParser {


    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll(" ", ""); // Remove whitespace
        String[] tokens = expression.split("((?<=\\+)|(?=\\+))|((?<=-)|(?=-))|((?<=\\*)|(?=\\*))|((?<=/)|(?=/))|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))"); // Split expression into numbers and operators
        Stack<Double> operandStack = new Stack<>(); // Operand stack
        Stack<Character> operatorStack = new Stack<>(); // Operator stack

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            char c = token.charAt(0);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                while (!operatorStack.isEmpty() && operatorPrecedence(operatorStack.peek()) >= operatorPrecedence(c)) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '('
            } else {
                operandStack.push(Double.parseDouble(token));
            }
        }

        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();

        switch (operator) {
            case '+':
                operandStack.push(operand1 + operand2);
                break;
            case '-':
                operandStack.push(operand1 - operand2);
                break;
            case '*':
                operandStack.push(operand1 * operand2);
                break;
            case '%':
                operandStack.push(operand1 % operand2);
                break;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                operandStack.push(operand1 / operand2);
                break;
        }
    }

    public static int operatorPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return -1;
    }
}