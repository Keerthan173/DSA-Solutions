package Infix_Postfix;

import java.util.Stack;

public class Q08_PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "953+4*6/-";

        Stack<String> valStack = new Stack<>();

        for(int i=0 ; i<postfix.length() ; i++){
            char ch = postfix.charAt(i);

            if(ch>='0' && ch<='9'){
                // If operand, convert char to String and push to stack
                valStack.push(ch + "");
            }
            else{
                // Operator: pop two operands and wrap as "(" + operand1 + operator + operand2 + ")", and push back.
                String b = valStack.pop();
                String a = valStack.pop();
                valStack.push("(" + a + ch + b + ")");
            }
        }
        System.out.println("Infix: "+ valStack.pop());
    }
}

// Output:
// Infix: (9-(((5+3)*4)/6))
