/*
Implement Stack using Queues 
PUSH Efficient - (Costly pop approach)
Push is O(1), Pop and Top are O(n)
This is simpler but pop and top both take longer time.
*/

package Problems;

import java.util.LinkedList;
import java.util.Queue;

// Custom stack class
class MyStack2 {
    Queue<Integer> q;

    public MyStack2() {
        q = new LinkedList<>();
    }

    // Push operation: O(1)
    public void push(int x) {
        q.add(x); // Simply add to queue
    }

    // Pop operation: O(n)
    public int pop() {
        int size = q.size();
        // Leave last element in queue, rotate rest
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove(); // Remove the actual "top"
    }

    // Top operation: O(n)
    public int top() {
        int size = q.size();
        // Leave last element in queue, rotate rest
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int val = q.peek(); // Peek the last element
        q.add(q.remove()); // Add it back to the queue
        return val;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class Q4a_StackUsingQueue {
    public static void main(String[] args) {
        System.out.println("Stack using Queues (Costly Pop)");
        MyStack2 s = new MyStack2();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.top());   // 30
        System.out.println(s.pop());   // 30
        System.out.println(s.top());   // 20
        System.out.println(s.empty()); // false
    }
}