package org.example.interview;

import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        String inputStr = "[()]";
        String invalidStr = "[(}){]";
        String invalidStrEmpty = "";
        boolean isExpressionValid = validExpression_v0(inputStr);
        System.out.println("validExpression :: " + isExpressionValid);
    }

    public static boolean validExpression_v0(String expression) {

        String[] charExpressions = expression.split("");
        // step1: check if character is open bracket then add
        // step2: else if character is closed bracket
        // pop the top element and check if the pop element matches with closed bracket.
        // step3: do the above till stack is not empty.

        int noOfChars = charExpressions.length;
        Stack<String> validExp = new Stack<String>();
        int i = 0;
        if (expression == null || expression.isEmpty()) {
            System.out.println("Invalid Expression");
            return false;
        } else if (charExpressions[i].equals("]") ||
                charExpressions[i].equals("}") ||
                charExpressions[i].equals(")")) {
            System.out.println("Invalid expression as it started with closed brackets");
            return false;
        }
        do {
            if (charExpressions[i].equals("[") || charExpressions[i].equals("{") || charExpressions[i].equals("(")) {
                validExp.push(charExpressions[i]);
            } else if (charExpressions[i].equals("]") ||
                    charExpressions[i].equals("}") ||
                    charExpressions[i].equals(")")) {
                String peek = validExp.peek();
                if ((peek.equals("[") && charExpressions[i].equals("]"))
                        || (peek.equals("{") && charExpressions[i].equals("}"))
                        || (peek.equals("(") && charExpressions[i].equals(")"))
                )
                    validExp.pop();


            } else
                return false;
            i++;

        } while (i < expression.length());
        if (!validExp.isEmpty())
            return false;
        else
            return true;


    }


}
