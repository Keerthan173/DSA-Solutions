package Problems;

/*
GFG: First negative integer in every window of size k
https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

Approach:
1. Use a queue to store indices of negative numbers.
2. First loop: store all negative indices in the queue.
3. Second loop: for each window, check if front of queue is in the current window.
    - If yes, add the corresponding negative number to result.
    - If no, remove from queue and add 0 if no valid negative index found.
*/

import java.util.*;

class Q6_FirstNegativeFromWindow {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // Step 1: Store all negative element indices in queue
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }

        // Step 2: Traverse each sliding window
        for (int i = 0; i <= n - k; i++) {
            // Remove index that is less than current window
            if (!q.isEmpty() && q.peek() < i) {
                q.remove();
            }

            // Check if front of queue is within current window
            if (!q.isEmpty() && q.peek() < i + k) {
                res.add(arr[q.peek()]);  // first negative number in the window
            } else {
                res.add(0);  // no negative number in the window
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        List<Integer> result = firstNegInt(arr, k);
        System.out.println(result);  // Output: [-1, -1, -7, 0, 0, 0]
    }
}