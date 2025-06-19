import java.util.Stack;

public class Stack06 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack (Recursive): " + stack);
    }

    // Function to reverse the stack
    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Reverse remaining stack
        reverseStack(stack);

        // Step 3: Insert popped element at bottom
        insertAtBottom(stack, top);
    }

    // Function to insert element at the bottom of stack
    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        // Pop top element
        int top = stack.pop();

        // Recursive call
        insertAtBottom(stack, value);

        // Push original top back after insertion
        stack.push(top);
    }
}


// | Method    | Time Complexity | Space Complexity            |
// | --------- | --------------- | --------------------------- |
// | Iterative | O(n)            | O(n) (extra stack)          |
// | Recursive | O(n)            | O(n) (recursive call stack) |
