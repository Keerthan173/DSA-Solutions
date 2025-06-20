// Problem: Check if a string of brackets is valid.
// Input: (()())
// Output: Is valid? true

// Input: (())
// Output: Is valid? true

// Input: ((()
// Output: Is valid? false

// Input: )(
// Output: Is valid? false


package Problems;

import java.util.Scanner;
import java.util.Stack;

public class Q1 {

    public static boolean isValid(String str) {

        // Odd-length strings can never be balanced
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        // If the character is '(', push it onto the stack.
        // If the character is ')':
            // If the stack is empty, there's no matching '(' → return false.
            // If the top of the stack is '(', pop it (matched pair).


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);  // Push opening bracket
            } 
            else {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }

                // Match found
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        // If stack is empty at the end, all brackets matched
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the brackets: ");
        String str = sc.nextLine();

        System.out.println("Is valid? " + isValid(str));

        sc.close();
    }
}
