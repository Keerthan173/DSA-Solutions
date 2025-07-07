package Infix_Postfix;

import java.util.Stack;

public class Q05PrefixEvaluation {
    public static void main(String[] args) {
        String prefix = "-9/*+5346";

        Stack<Integer> valStack = new Stack<>();        // Stack to hold operands

        for(int i=prefix.length()-1 ; i>=0 ; i--){
            char ch = prefix.charAt(i);

            if(ch>='0' && ch<='9'){
                // If operand, convert char to int and push to stack
                valStack.push(ch - '0');
            }
            else{
                // Operator: pop two operands and apply operator
                int a = valStack.pop();     // first operand
                int b = valStack.pop();     // second operand
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