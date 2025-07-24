// Queue Basics in Java using LinkedList

import java.util.LinkedList;
import java.util.Queue;

class File01_Basics {
    public static void main(String[] args) {
        // Queue<Integer> q = new Queue<>();  // ❌ Error: Queue is an interface and cannot be instantiated

        // ✅ Correct way: LinkedList implements Queue
        Queue<Integer> q = new LinkedList<>();

        // Check if queue is empty
        System.out.println(q.isEmpty());  // true

        // Add elements to the queue (at the rear)
        q.add(1);
        System.out.println(q.isEmpty());  // false
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Print current queue
        System.out.println(q);  // [1, 2, 3, 4, 5]

        // Size of the queue
        System.out.println(q.size());  // 5

        // Remove element from front (head)
        q.remove();  // Removes 1
        System.out.println(q);  // [2, 3, 4, 5]

        // Remove element from front using poll()
        q.poll();  // Removes 2
        System.out.println(q);  // [3, 4, 5]

        // Peek at the front without removing using element()
        System.out.println(q.element());  // 3

        // Peek at the front without removing using peek()
        System.out.println(q.peek());  // 3
    }
}

/*
--------------------------------------------
✔ Queue is a FIFO structure (First In First Out)

✔ Interface: Queue

🔹 Common Methods:
   - add(E): Add element to rear
   - remove(): Remove and return front (throws exception if empty)
   - poll(): Remove and return front (returns null if empty)
   - element(): Peek front (throws exception if empty)
   - peek(): Peek front (returns null if empty)
   - isEmpty(): Check if queue is empty
   - size(): Returns size of queue

*/