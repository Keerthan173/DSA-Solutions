// GFG - Reverse the first k elements of a queue
// https://www.geeksforgeeks.org/reversing-first-k-elements-queue/

package Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q3_ReverseFirstK {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        int k = 3;
        reverseK(q, k);
        System.out.println(q); // Output: [30, 20, 10, 40, 50]
    }

    // Function to reverse the first k elements of the queue
    static void reverseK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return;

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        // Step 2: Enqueue the elements from stack (reversed k elements)
        while (stack.size() > 0) {
            q.add(stack.pop());
        }

        // Step 3: Move the remaining elements (size - k) to the back of the queue
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }
}
