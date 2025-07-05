// Next Greater Element to the Right
// The next greater element for an element x is the first element to the right of x that is greater than x.
// If no such element exists, assign -1.

// Input   : arr =  {10, 6, 6,  8, 12,  4, 1,  3}
// Expected Output: [12, 8, 8, 12, -1, -1, 3, -1]


// We process elements from right to left, so that we can always maintain a stack of "potential next greater elements".
// For every element arr[i]:
    // We remove all elements from the stack that are less than or equal to arr[i], 
    // because they can never be the next greater for this or any earlier element.

    // If the stack is empty → No next greater → -1

    // Else → Top of the stack is the next greater

    // Push arr[i] to the stack for use in upcoming elements.

package Problems;

import java.util.Arrays;
import java.util.Stack;

public class Q5b {

    static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack that are smaller than or equal to current element
            while (st.size() > 0 && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, there is no greater element to the right
            if(st.size()==0){
                res[i] = -1;
            }
            else{
                // Top of the stack is the next greater element
                res[i] = st.peek();
            }

            // Push current element to stack for future elements
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 6, 6, 8, 12, 4, 1, 3 };
        int[] res = nextGreater(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}

// | i | arr\[i] | Action                              | Stack after action | res\[i] |
// | - | ------- | ----------------------------------- | ------------------ | ------- |
// | 7 | 3       | Stack empty                         |  [3]               | -1      |
// | 6 | 1       | 3 > 1 → res = 3                     |  [3, 1]            | 3       |
// | 5 | 4       | 1, 3 < 4 → pop all, stack empty     |  [4]               | -1      |
// | 4 | 12      | 4 < 12 → pop, stack empty           |  [12]              | -1      |
// | 3 | 8       | 12 > 8 → res = 12                   |  [12, 8]           | 12      |
// | 2 | 6       | 8 > 6 → res = 8                     |  [12, 8, 6]        | 8       |
// | 1 | 6       | 6 == 6 → pop, 8 > 6 → res = 8       |  [12, 8, 6]        | 8       |
// | 0 | 10      | 6, 8 < 10 → pop, 12 > 10 → res = 12 |  [12, 10]          | 12      |




// Stack-based method
// for (int i = n - 1; i >= 0; i--) {
//     while (!stack.isEmpty() && stack.peek() <= arr[i]) {
//         stack.pop();
//     }
//     res[i] = stack.isEmpty() ? -1 : stack.peek();
//     stack.push(arr[i]);
// }

// Time Complexity: O(n)
// Each element is pushed and popped from the stack at most once.
// Total operations = O(n) (not nested).
// Efficient because the inner while loop does not run n times for each i — it depends on how many elements are smaller.

// Space Complexity: O(n)
// In the worst case, all elements are in increasing order → entire array is pushed into the stack.
// So auxiliary space used by the stack = O(n).