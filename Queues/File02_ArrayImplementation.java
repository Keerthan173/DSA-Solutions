// Queue (Array Implementation - Non-Circular)
// Custom implementation of a queue using array (with front, rear, size tracking)

public class File02_ArrayImplementation {
    public static class QueueA {
        int front = -1;                  // Index of front element
        int rear = -1;                   // Index of rear element
        int size = 0;                    // Current number of elements in the queue
        int[] arr = new int[5];          // Static array of fixed size (5 elements)

        // Add element to the queue
        public void add(int val) {
            if (rear == arr.length - 1) {
                System.out.println("Queue is full.");
                return;
            }
            if (front == -1) {
                front = 0;               // Initialize front on first insertion
            }
            arr[++rear] = val;           // Increment rear and insert value
            size++;
        }

        // Remove element from the front
        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            size--;
            return arr[front++];         // Return front and move front forward
        }

        // Peek front element without removing
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[front];
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Display the current queue
        public void display() {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueA q = new QueueA();

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);        // Exceeds capacity, will print "Queue is full."

        q.display();     // Queue: 1 2 3 4 5

        q.remove();      // Removes 1
        q.display();     // Queue: 2 3 4 5

        System.out.println(q.remove());  // 2
        q.remove();      // Removes 3
        q.remove();      // Removes 4
        q.remove();      // Removes 5
        q.remove();      // Queue is empty!
        System.out.println(q.isEmpty());     // true
    }
}


/*
----------------------------------------------------------

🚫 Limitations:
- Once elements are removed, that space can't be reused (non-circular)
- After 5 insertions, even if some are removed, further insertions fail

----------------------------------------------------------
📌 Tip: For production or reusable code, use circular queue to avoid wasted space
*/