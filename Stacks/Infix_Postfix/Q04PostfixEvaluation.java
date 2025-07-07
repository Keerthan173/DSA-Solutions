package Infix_Postfix;

import java.util.Stack;

public class Q04PostfixEvaluation {
    public static void main(String[] args) {
        String postfix = "953+4*6/-";

        Stack<Integer> valStack = new Stack<>();        // Stack to hold operands

        for(int i=0;i<postfix.length();i++){
            char ch = postfix.charAt(i);

            if(ch>='0' && ch<='9'){
                // If operand, convert char to int and push to stack
                valStack.push(ch - '0');
            }
            else{
                // Operator: pop two operands and apply operator
                int b = valStack.pop();
                int a = valStack.pop();
                switch (ch) {
                    case '+': valStack.push(a + b);    break;
                    case '-': valStack.push(a - b);    break;
                    case '*': valStack.push(a * b);    break;
                    case '/': valStack.push(a / b);    break;
                }
            }
        }
        System.out.println("Result: "+ valStack.pop());
    }
}

// Output:
// Result: 4