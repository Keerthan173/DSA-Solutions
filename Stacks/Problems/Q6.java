// Previous Greater Element
// For each element in the array, find the closest greater element on the left side.
// If none exists, set -1.

// Input: arr = { 10,  6,  6,  8, 12,  4, 1, 3 }
// Output:      [ -1, 10, 10, 10, -1, 12, 4, 4 ]

package Problems;

import java.util.Arrays;
import java.util.Stack;

public class Q6 {
    static int[] previousGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(stack.size()>0 && arr[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
            System.out.println(stack);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 6, 6, 8, 12, 4, 1, 3 };
        int[] res = previousGreater(arr);
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Previous greater: " + Arrays.toString(res));
    }
}


// Output:
// [10]
// [10, 6]
// [10, 6]
// [10, 8]
// [12]
// [12, 4]
// [12, 4, 1]
// [12, 4, 3]
// Original: [10, 6, 6, 8, 12, 4, 1, 3]
// Previous greater: [-1, 10, 10, 10, -1, 12, 4, 4]



// How It Works:
    // You go from left to right and use a stack to keep track of candidates for the "previous greater".
    // For each arr[i], you pop all elements from the stack that are less than or equal to arr[i].
    // If the stack is not empty, the top is your previous greater.
    // Then, push arr[i] to stack for future comparisons.


// Time Complexity: O(n) — each element is pushed and popped at most once.
// Space Complexity: O(n) — stack may store all elements in worst case.