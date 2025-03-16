package Cyclic_Sort;
// Given an unsorted integer array nums. 
// Return the smallest positive integer that is not present in nums.


// Hint:
// Why Can We Use Cyclic Sort Even Though the Range Is Not Strictly [1, n]?

// Cyclic Sort Works for Numbers in a Known Range
// Normally, cyclic sort is used when numbers are in the range [1, n].
// In this problem, numbers are not necessarily in this range, but we can still apply cyclic sort for numbers that fit within the range.

// Ignoring Out-of-Range and Negative Numbers
// Numbers ≤ 0 and greater than n are ignored in sorting because they cannot be placed in valid positions (1 to n).
// These numbers don’t affect the result since the missing number must be in [1, n+1].

// Sorting Within Valid Range
// The valid numbers (1 to n) are placed in their correct positions if possible.
// This allows us to easily detect the missing smallest positive number in a single pass after sorting.

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr={1,2,0};  //3
        // int[] arr={3,4,-1,1};  //2
        // int[] arr={7,8,9,11,12};  //1
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            // Swap only if:
            //  arr[i] is a positive number
            //  arr[i] is within the valid range [1, arr.length]

            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

         // If all numbers are in their correct positions, return `n+1`
         // If arr = [ 1,2,3] --> 4 is first missing positive.
        return arr.length + 1;
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}