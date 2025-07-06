// Approach 1: Using Two Stacks
    // Main Stack – stores all the values normally.
    // Min Stack – stores the current minimum at each step.

// How it works:
    // On push(x):
        // Push x to main stack.
        // If minStack is empty or x <= minStack.peek(), push x to minStack.

    // On pop():
        // Pop from main stack.
        // If the popped value equals minStack.peek(), pop from minStack too.

    // On getMin():
        // Return minStack.peek() (constant time).

package MinStack;

import java.util.Stack;

public class Solution1 {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    // Constructor
    public Solution1() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove the element on top of the stack
    public void pop() {
        int popped = mainStack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return mainStack.peek();
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }

    // For printing purpose (optional)
    public void printStacks() {
        System.out.println("Main Stack: " + mainStack);
        System.out.println("Min Stack: " + minStack);
    }

    // Demo
    public static void main(String[] args) {
        Solution1 stack = new Solution1();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(6);

        stack.printStacks();
        System.out.println("Current Min: " + stack.getMin());  // 2

        stack.pop(); // Pops 6
        stack.pop(); // Pops 2

        stack.printStacks();
        System.out.println("Current Min after pops: " + stack.getMin()); // 3
    }
}


// Output:
// Main Stack: [5, 3, 7, 2, 6]
// Min Stack: [5, 3, 2]
// Current Min: 2
// Main Stack: [5, 3, 7]
// Min Stack: [5, 3]
// Current Min after pops: 3


// Time Complexity - O(1)
// Space Complexity - O(N)