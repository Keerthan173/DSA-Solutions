// Given a string with only '(' and ')', return the minimum number of brackets to remove to make it valid (balanced).
// Input: "(()))("
// Output: 2
// Explanation: Remove 1 `)` and 1 `(`.

package Problems;

import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static int minRemovals(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop(); // Match found
                } else {
                    stack.push(ch); // Unmatched closing bracket ')'
                }
            }
        }
        // Remaining in stack are unmatched brackets
        return stack.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bracket string: ");
        String input = sc.nextLine();

        int result = minRemovals(input);
        System.out.println("Minimum brackets to remove = " + result);

        sc.close();
    }
}

// Enter the bracket string: )
// Minimum brackets to remove = 1

// Enter the bracket string: ()(
// Minimum brackets to remove = 1

// Enter the bracket string: (()))(
// Minimum brackets to remove = 2
