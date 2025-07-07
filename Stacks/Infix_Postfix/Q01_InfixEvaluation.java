// Evaluate a string expression (infix notation) like "9-(5+3)*4/6"
// Infix: Operators are written between operands, and precedence must be respected.


// Infix Evaluation – Working (Step-by-Step)
// 1. Two stacks are used:
//     valStack: Stores numbers (operands).
//     opStack: Stores operators (+, -, *, /, (, )).

// 2. Read each character of the expression from left to right:
//     If it’s a digit, convert it to number and push to valStack.
//     If it’s an opening bracket (, push to opStack.
//     If it’s a closing bracket ), keep popping and computing until ( is found.
//     If it’s an operator (+, -, *, /):
//         Check precedence: while the top of opStack has higher or equal precedence, compute the result using top two values in valStack.
//         Then push the current operator to opStack.

// 3. After the loop, compute any remaining operations in the stacks.

// 4. Final result is the only value left in valStack.


package Infix_Postfix;

import java.util.Stack;

public class Q01_InfixEvaluation {
    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";

        Stack<Integer> valStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);

            if(ch>='0' && ch<='9'){
                valStack.push(ch-'0');      // Convert char digit to int and push
            }
            else if(ch=='('){
                    opStack.push(ch);       // Push opening parenthesis
            }
            else if(ch==')'){
                // Evaluate till matching '('
                while(opStack.peek()!='('){
                    compute(valStack, opStack);
                }
                opStack.pop();      // Remove '('
            }
            else if(isOperator(ch)){
                // While top of stack has equal/higher precedence, evaluate
                while (opStack.size()>0 && precedence(opStack.peek())>=precedence(ch)) {
                    compute(valStack, opStack);
                }
                opStack.push(ch);       // Push current operator
            }
        }
        // Evaluate remaining operators
        while(!opStack.isEmpty()){
            compute(valStack, opStack);
        }

        System.out.println("Result: "+valStack.pop());
    }

    static void compute(Stack<Integer> valStack, Stack<Character> opStack){
        int b = valStack.pop();
        int a = valStack.pop();
        char op = opStack.pop();

        switch (op) {
            case '+': valStack.push(a+b); break;
            case '-': valStack.push(a-b); break;
            case '*': valStack.push(a*b); break;
            case '/': valStack.push(a/b); break;
        }
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
// 9 - (5 + 3) * 4 / 6
// 9 - 8 * 4 / 6
// 9 - 32 / 6
// 9 - 5 (integer division)
// 4