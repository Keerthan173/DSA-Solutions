// Queue using Linked List
// Custom implementation of a queue using a singly linked list

public class File03_LLImplementation {

    // Node class representing each element of the queue
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // Queue class using Linked List
    public static class QueueLL {
        Node head;    // Front of the queue
        Node tail;    // Rear of the queue
        int size = 0;

        // Add element to the rear of the queue
        public void add(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;   // First element
            } else {
                tail.next = temp;     // Append to rear
                tail = temp;
            }
            size++;
        }

        // Remove element from the front of the queue
        public int remove() {
            if (head == null) {
                System.out.println("Queue is empty!");
                return -1;
            }
            int x = head.val;
            head = head.next;
            if(head == null) tail = null;  // when last element is removed
            size--;
            return x;
        }

        // Peek the front element without removing
        public int peek() {
            if (head == null) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return head.val;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Display all elements of the queue
        public void display() {
            if (head == null) {
                System.out.println("Queue is empty!");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        
        q.add(1);
        q.add(2);
        q.add(3);
        q.display();               // 1 2 3

        System.out.println(q.isEmpty());  // false

        q.remove();
        q.display();               // 2 3

        q.remove();
        q.remove();
        q.remove();                // Queue is empty!

        System.out.println(q.isEmpty());  // true
    }
}


/*

Advantage over array: No size limitation, dynamic memory.

Disadvantages: Extra Memory Usage
    Each node requires extra memory for the pointer (next reference).
    Compared to arrays, linked lists have higher memory overhead.

*/