// Stack demonstrating recursive printing of elements in reverse order and normal order.

import java.util.Stack; 
public class Stack04 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Stack is displayed using toString() method
        // which is overridden in Stack class to show elements in LIFO order
        System.out.println(stack);      // [1, 2, 3, 4, 5]

        // Stack could also be displayed by recursive method
        printRecursivelyReverse(stack);     // 5 4 3 2 1
        printRecursively(stack);        // 1 2 3 4 5

        // Stack is unchanged after recursive print
        System.out.println(stack);      // [1, 2, 3, 4, 5]
    }

    public static void printRecursivelyReverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // Base case: stack is empty
        }
        int top = stack.pop(); // Pop the top element
        System.out.print(top + " "); // Print the popped element
        printRecursivelyReverse(stack); // Recursive call with the remaining stack
        stack.push(top); // Push the popped element back onto the stack
    }
    
    public static void printRecursively(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        printRecursively(stack);
        System.out.print(top + " "); // Print the popped element after recursive call
        stack.push(top);
    }
}
