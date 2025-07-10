/*
Leetcode 232: Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/
Pop-efficient (Costly push, Fast pop)
Push(): O(n), pop() and peek(): O(1)
Space: O(n)

We need two stacks to implement a queue, since in stacks we have only one entry/exit point.
 */

package Problems;

import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push new element into s1
        s1.push(x);

        // Move all elements back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop(); // Front is always on top
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// Example usage
public class Q5_QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.empty()); // false
    }
}
