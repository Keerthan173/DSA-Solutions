// Leetcode 239: Sliding Window Maximum

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
// You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.
// Return the max sliding window.

// Example :
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7




// Approach 1: Brute Force for Sliding Window Maximum
    // In this approach, we use two nested loops:
    // The outer loop moves the window from the start to the end of the array.
    // The inner loop scans each window of size k to find the maximum element.

package Sliding_Window_Maximum;

import java.util.Arrays;

public class Sol1 {
    public static void main(String[] args) {
        int[] nums = { 1,3,-1,-3,5,3,6,7 };
        int[] ans = myFunc(nums, 3);        // 3 is the window size
        System.out.println(Arrays.toString(ans));       // [3, 3, 5, 5, 6, 7]
    }
    static int[] myFunc(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];         // Number of windows = n - k + 1
        int z=0;

        for(int i=0 ; i<n-k+1 ; i++){
            int max = Integer.MIN_VALUE;
            
            for(int j=i ; j<i+k ; j++){
                if(nums[j]>max){
                    max = nums[j];
                }
            }
            res[z++] = max;
        }
        return res;
    }
}

// | Aspect           | Complexity                                               |
// | ---------------- | -------------------------------------------------------- |
// | Time Complexity  | O(n * k) — for each window (n−k+1), we do k comparisons  |
// | Space Complexity | O(n - k + 1) — to store the result                       |
