// The Fibonacci sequence is defined as:
// 𝐹(𝑛)=𝐹(𝑛−1)+𝐹(𝑛−2)
// Base cases:
// F(0) = 0
// F(1) = 1
// Example Fibonacci series:0, 1, 1, 2, 3, 5, 8, 13, 21, ...
public class Fibonacci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] testCases = {0, 1, 2, 5, 10, 15};

        for (int n : testCases) {
            System.out.println("Fib(" + n + ") = " + solution.fib(n));
        }
    }
}

class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n; // Base case: Fib(0) = 0, Fib(1) = 1
        }

        //Method 1 : Recursive
        // return fib(n-1) + fib(n-2);
        //inefficient (O(2^n))

        //Method 2 :
        int a = 0, b = 1, c;
        for (int i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a; // Return the nth Fibonacci number
        //Time Complexity: O(n) (linear time).
    }
}
