package Infix_Postfix;

import java.util.Stack;

public class Q06PostfixToPrefix {
    public static void main(String[] args) {
        String postfix = "953+4*6/-";

        Stack<String> valStack = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char ch = postfix.charAt(i);

            if(ch>='0' && ch<='9'){
                // If operand, convert char to String and push to stack
                valStack.push(ch + "");
            }
            else{
                // Operator: pop two operands and push partial prefix expression
                String b = valStack.pop();
                String a = valStack.pop();
                valStack.push(ch + a + b);
            }
        }
        System.out.println("Prefix: "+ valStack.pop());
    }
}

// Output:
// Prefix: -9/*+5346
