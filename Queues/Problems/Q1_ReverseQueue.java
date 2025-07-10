/*
Reverse a Queue
Approach: Use a stack to reverse the order of queue elements

Queue: [1, 2, 3, 4]  (front = 1, rear = 4)
Step 1: Dequeue all elements from the queue and push them onto a stack
    Queue: []
    Stack: [1, 2, 3, 4]  (top = 4)
Step 2: Pop all elements from the stack and enqueue them back to the queue
    Queue: [4, 3, 2, 1]  (front = 4, rear = 1)
*/



package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q1_ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Original Queue: " + q); // [1, 2, 3, 4]

        // Create a stack to reverse the queue
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue from queue and push into stack
        while (q.size() > 0) {
            stack.push(q.remove());
        }
        // System.out.println("Stack after pushing elements: " + stack);// [1, 2, 3, 4] (top = 4)

        // Step 2: Pop from stack and enqueue back to queue
        while (stack.size() > 0) {
            q.add(stack.pop());
        }

        System.out.println("Reversed Queue: " + q); // [4, 3, 2, 1]
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) for the stack