package Infix_Postfix;

import java.util.Stack;

public class Q09_PrefixToInfix {
    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        Stack<String> stack = new Stack<>();

        // Traverse prefix from right to left
        for(int i=prefix.length()-1 ; i>=0 ; i--){
            char ch = prefix.charAt(i);

            if(ch>='0' && ch<='9'){
                stack.push(ch + "");
            }
            else{
                String a = stack.pop();
                String b = stack.pop();
                stack.push("(" + a + ch + b + ")");     // Infix = "(" + operand1 + operator + operand2 + ")"
            }
        }

        System.out.println("Infix: " + stack.pop());
    }
}

// Output:
// Infix: (9-(((5+3)*4)/6))