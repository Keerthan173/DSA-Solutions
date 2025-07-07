package Infix_Postfix;

import java.util.Stack;

public class Q02_InfixToPrefix {
    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";

        Stack<String> valStack = new Stack<>();     // Stores operands as strings (prefix fragments)
        Stack<Character> opStack = new Stack<>();

        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);

            if(ch>='0' && ch<='9'){
                valStack.push("" + ch);       // Convert digit to string and push
            }
            else if(ch=='('){
                opStack.push(ch);
            }
            else if(ch==')'){
                while(opStack.peek()!='('){
                    convert(valStack, opStack);
                }
                opStack.pop();
            }
            else if(isOperator(ch)){
                while (opStack.size()>0 && precedence(opStack.peek())>=precedence(ch)) {
                    convert(valStack, opStack);
                }
                opStack.push(ch);
            }
        }
        while(opStack.size()>0){
            convert(valStack, opStack);
        }
        System.out.println("Prefix: " + valStack.pop());
    }

    // Combines operator and two operands into prefix format
    static void convert(Stack<String> valStack, Stack<Character> opStack){
        String b = valStack.pop();
        String a = valStack.pop();
        char op = opStack.pop();

        String expr = op + a + b;       // Prefix: operator + operand1 + operand2
        valStack.push(expr);
    }

    static boolean isOperator(char ch){
        return ch=='+' || ch=='-' || ch=='*' || ch=='/';
    }

    static int precedence(char op){
        if(op=='+' || op=='-')  return 1;
        if(op=='*' || op=='/')  return 2;
        return 0;
    }
}


// Output: 
// Prefix: -9/*+5346

// 9 - (5 + 3) * 4 / 6
// 9 - +53 * 4 / 6
// 9 - *+534 / 6
// 9 - /*+ 5346
// -9/*+5346