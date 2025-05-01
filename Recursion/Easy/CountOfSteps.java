// Given an integer num, return the number of steps to reduce it to zero.
// In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

public class CountOfSteps {
    public static void main(String[] args) {
        int steps=numberOfSteps(14);       
        System.out.println(steps);                  //6
    }
    static int numberOfSteps(int num) {
        return helper(num, 0);
    }
    static int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if (num % 2 == 0) {
            return helper(num/2, steps+1);
        }
        return helper(num-1, steps+1);
    }
}
