// The Tribonacci sequence is similar to Fibonacci but with three previous terms:
// T(n)=T(n−1)+T(n−2)+T(n−3)
// Base cases:
// T(0)=0,T(1)=1,T(2)=1
public class Tribonacci {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {0, 1, 2, 5, 10, 15};

        for (int n : testCases) {
            System.out.println("Tribonacci(" + n + ") = " + solution.tribonacci(n));
        }
    }
}

class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n; // Base case: Tribonacci(0) = 0, Tribonacci(1) = 1
        } else if (n == 2) {
            return 1; // Base case: Tribonacci(2) = 1
        }

        // Method 1: Recursive (inefficient)
        // return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3); // O(2^n) time complexity

        // Method 2: Iterative (Efficient)
        int a = 0, b = 1, c = 1, d;
        for (int i = 3; i <= n; i++) { // Loop starts from 3 (as Tribonacci(2) is already known)
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c; // Return the nth Tribonacci number
        // Time Complexity: O(n) (linear time).
    }
}
