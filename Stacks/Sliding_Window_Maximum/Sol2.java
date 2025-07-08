// Leetcode 239: Sliding Window Maximum

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]


// Approach 2 — Using NGE (Next Greater Element)
// 1. Preprocess with NGE:
//     Create a nextGreater[] array.
//     For each index i, store the index of the next greater element to the right of nums[i].
//     If no greater element exists, store -1.

// 2. Sliding Window Processing:
//     For each window starting at index i, use nextGreater to jump to the next larger element.
//     Repeat this jumping while staying within the window (i.e., j < i + k).

// In the Next Greater Element (NGE) based approach:
    // You're jumping from one index to the next greater using nextGreater[].
    // You're allowed to jump only while the next greater is within the window (nextGreater[j] < i + k).
    // As soon as nextGreater[j] is outside the current window, that means:
        // There is no greater element inside the window, hence
        // nums[j] is the maximum element in that window.


package Sliding_Window_Maximum;

import java.util.Arrays;
import java.util.Stack;

public class Sol2 {
    public static void main(String[] args) {
        int[] nums = { 1,3,-1,-3,5,3,6,7 };
        int[] ans = myFunc(nums, 3);        // 3 is the window size
        System.out.println(Arrays.toString(ans));       // [3, 3, 5, 5, 6, 7]
    }
    static int[] myFunc(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int z=0;

        // Finding next greater element
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[n];
        for(int i=n-1 ; i>=0 ; i--){
            while(stack.size()>0 && nums[i]>=nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        // System.out.println("Next Greater : " + Arrays.toString(nextGreater));        // Next Greater : [1, 4, 4, 4, 6, 6, 7, -1]

        // Process each sliding window
        for(int i=0 ; i<n-k+1 ; i++){
            int max = Integer.MIN_VALUE;
            int j = i;
            while(j!=-1 && j<i+k){
                max = nums[j];
                j = nextGreater[j];
            }
            res[z++] = max;
        }
        return res;
    }
}

// Total Time Complexity = O(n)
// Total Space Complexity = O(n)