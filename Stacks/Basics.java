// Import the Stack class from Java's collection framework
import java.util.Stack;

public class Basics {
    public static void main(String[] args) {
        
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // -------------------- PUSH --------------------
        // Add elements to the top of the stack using push()
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack after pushes: " + stack);  // [10, 20, 30, 40]

        // -------------------- PEEK --------------------
        // peek() returns the top element without removing it
        System.out.println("Top element (peek): " + stack.peek());  // 40

        // -------------------- POP --------------------
        // pop() removes and returns the top element
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);  // 40
        System.out.println("Stack after pop: " + stack);  // [10, 20, 30]

        // -------------------- SEARCH --------------------
        // search(element) returns position from top of the stack (1-based), or -1 if not found
        int position = stack.search(20);
        System.out.println("Position of 20 from top: " + position);  // 2

        // -------------------- EMPTY CHECK --------------------
        // isEmpty() checks if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());  // false

        // -------------------- SIZE --------------------
        // size() gives the number of elements in the stack
        System.out.println("Current size of stack: " + stack.size());  // 3

        // -------------------- CLEAR --------------------
        // Clear the stack completely
        stack.clear();
        System.out.println("Stack after clearing: " + stack);  // []
    }
}