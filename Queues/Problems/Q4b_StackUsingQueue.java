/*
Leetcode 225: Implement Stack using Queues 
POP Efficient - (Costly push approach)
https://leetcode.com/problems/implement-stack-using-queues/
Push is O(n), Pop and Top are O(1)
This is more better than push efficient approach - Pop and top are both O(1) here.
*/

package Problems;

import java.util.LinkedList;
import java.util.Queue;

// Custom stack class
class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push operation: O(n)
    public void push(int x) {
        q.add(x);
        int size = q.size();
        // Rotate to move new element to the front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove(); // Always removes the "top" element
    }

    public int top() {
        return q.peek(); // Always gives the "top" element
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class Q4b_StackUsingQueue {
    public static void main(String[] args) {
        System.out.println("Stack using Queues (Costly Push)");
        MyStack s = new MyStack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.top());   // 30
        System.out.println(s.pop());   // 30
        System.out.println(s.top());   // 20
        System.out.println(s.empty()); // false
    }
}