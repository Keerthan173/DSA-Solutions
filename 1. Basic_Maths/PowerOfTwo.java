//Given an integer n, return true if it is a power of two. Otherwise, return false.
public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] testCases = {1, 2, 16, 18, 32, 64, 100};
        
        for (int n : testCases) {
            System.out.println(n + " is power of two? " + solution.isPowerOfTwo(n));
        }
    }
}

//Method 1 :
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false; // Any number less than 1 is not a power of two
        }
        if (n == 1) {
            return true; // 2^0 = 1, which is a power of two
        }
        
        // Keep dividing by 2 while n is even
        while (n % 2 == 0) {
            n = n / 2;
        }
        
        // If after all divisions n becomes 1, then it is a power of two
        return n == 1;
    }
}
// ✅ Input: n = 8 → true (8 → 4 → 2 → 1)
// ✅ Input: n = 10 → false (10 → 5 (not divisible by 2))
// 🔹 Time Complexity: O(log n) (since n is divided by 2 in each step)

//Method 2 : Bitwise AND
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         return n > 0 && (n & (n - 1)) == 0;
//     }
// }
// Example:
// 8 (1000) & 7 (0111) = 0000 ✅
// 10 (1010) & 9 (1001) = 1000 ❌
// 🔹 Time Complexity: O(1) - more efficient.
