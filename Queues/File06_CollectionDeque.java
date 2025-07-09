// DEQUE USING COLLECTION FRAMEWORK
// - Deque (Double-Ended Queue) allows insertion & deletion from both ends.
// - Java provides Deque interface and ArrayDeque class for efficient implementation.
// - Common Deque methods: addFirst(), addLast(), removeFirst(), removeLast(), peekFirst(), peekLast()

import java.util.ArrayDeque;
import java.util.Deque;

public class File06_CollectionDeque {
    public static void main(String[] args) {
        // Deque = Double Ended Queue
        Deque<Integer> dq = new ArrayDeque<>();

        // Inserting elements
        dq.addFirst(10);   // Insert at front
        dq.addLast(20);    // Insert at rear
        dq.addFirst(5);
        dq.addLast(25);
        dq.add(77);         // Insert at rear (equivalent to addLast)

        System.out.println("Deque: " + dq);   // Deque: [5, 10, 20, 25, 77]

        // Peeking elements
        System.out.println("Front: " + dq.peekFirst());  // 5
        System.out.println("Rear: " + dq.peekLast());    // 25
        System.out.println(dq.peek());  // 5 (equivalent to peekFirst)

        // Removing elements
        dq.removeFirst();  // Remove from front
        dq.removeLast();   // Remove from rear
        dq.remove();  // Remove from front (equivalent to removeFirst)

        System.out.println("Deque after removal: " + dq); // Deque after removal: [20, 25]

        // Check if empty
        System.out.println("Is empty? " + dq.isEmpty());  // false

        // Size of deque
        System.out.println("Size: " + dq.size());  // 2
    }
}