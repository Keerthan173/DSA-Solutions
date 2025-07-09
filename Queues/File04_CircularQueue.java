/*

In a normal (linear) array-based queue, once the rear reaches the end of the array, 
we can’t insert even if there is space at the front due to deletions.

Circular Queue reuses that empty space by wrapping around.

Example:
Imagine a queue of size 5:

Initial state after adding 5 elements:
[10, 20, 30, 40, 50]
front → 0       rear → 4

After removing 2 elements:
[--, --, 30, 40, 50]
front → 2       rear → 4

Now you can still add new items at the front:
[60, 70, 30, 40, 50]
      ↑   ↑
    rear front

*/

public class File04_CircularQueue {

    public static class CircularQueue{
        int[] arr;
        int front = -1;
        int rear = -1;
        int size;
        int n;

        public CircularQueue(int n){
            this.n = n;
            arr = new int[n];
        }

        // Add element to the queue
        public void add(int val) throws Exception{
            if (size == n) {
                throw new Exception("Queue is full!");
            }
            if (front == -1) {
                front = 0;               // Initialize front on first insertion
            }
            rear = (rear+1) % n;
            arr[rear] = val;           // Increment rear and insert value
            size++;
        }

        // Remove element from queue (dequeue)
        public int remove() throws Exception{
            if (size == 0) {
                throw new Exception("Queue is empty!");
            }
            int removed = arr[front];
            front = (front + 1) % n; // move front in circular manner
            size--;
            return removed;
        }

        // Peek front element
        public int peek() throws Exception{
            if (size == 0) {
                throw new Exception("Queue is empty!");
            }
            return arr[front];
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check if queue is full
        public boolean isFull() {
            return size == n;
        }

        // Display all elements of queue
        public void display() throws Exception{
            if (size == 0) {
                throw new Exception("Queue is empty!");
            }
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % n] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        CircularQueue q = new CircularQueue(5);  // Queue size 5

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.display();  // Queue: 10 20 30 40 50

        q.remove();
        q.remove();
        q.display();  // Queue: 30 40 50

        q.add(60);
        q.add(70);
        q.display();  // Queue: 30 40 50 60 70

        System.out.println("Peek: " + q.peek());  // 30

        q.remove();
        q.remove();
        q.remove();
        q.remove();
        // q.remove();  // Exception in thread "main" java.lang.Exception: Queue is empty!
        q.display();    // Queue: 70
    }
}