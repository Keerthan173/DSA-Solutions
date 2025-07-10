// Reversing queues by recursion without using any additional data structures like stacks.

package Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_ReverseQueueRecursion {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Original Queue: " + q); // [1, 2, 3, 4]

        reverseQueue(q);

        System.out.println("Reversed Queue: " + q); // [4, 3, 2, 1]
    }

    // Function to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> q) {
        // Base case: if queue is empty, return
        if (q.isEmpty()) {
            return;
        }

        // Step 1: Remove front element
        int val = q.remove();

        // Step 2: Recursively reverse remaining queue
        reverseQueue(q);

        // Step 3: Add the removed element at the end
        q.add(val);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n) for the recursion stack

/*
Example Queue: [1, 2, 3, 4]

➤ First Call:
    Remove 1 → Now queue = [2, 3, 4]
    Recursive call on [2, 3, 4]

➤ Second Call:
    Remove 2 → Now queue = [3, 4]
    Recursive call on [3, 4]

➤ Third Call:
    Remove 3 → Now queue = [4]
    Recursive call on [4]

➤ Fourth Call:
    Remove 4 → Now queue = []
    Recursive call on []

➤ Base Case:
    Queue is empty → return

⬆️ Unwinding the Recursion (return phase):
At this point, we start adding back the removed elements:

Add 4 → queue becomes [4]
Add 3 → queue becomes [4, 3]
Add 2 → queue becomes [4, 3, 2]
Add 1 → queue becomes [4, 3, 2, 1]

Final Result:
Queue is now reversed: [4, 3, 2, 1]

*/