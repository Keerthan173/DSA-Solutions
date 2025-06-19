// Reverse a Stack (Iterative Approach)
import java.util.Stack;

public class Stack05 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println("Original Stack: " + stack);

        // Iteratively reverse the stack using another stack
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        System.out.println("Reversed Stack (Iterative): " + temp);
    }
}

// Output:
// Original Stack: [1, 2, 3, 4]
// Reversed Stack (Iterative): [4, 3, 2, 1]