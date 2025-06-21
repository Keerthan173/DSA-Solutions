// Remove Adjacent Duplicate Groups from Array
// Given an integer array, remove elements that appear in adjacent duplicate groups.
// Example: [1,2,2,3,10,10,10,5,7,7,2] → Output: [1, 3, 5, 2]

package Problems;

import java.util.Arrays;
import java.util.Stack;


public class Q4 {
    public static void main(String[] args) {
        // int[] arr = {1,2,2,3,10,10,10,5,7,7,2};
        int[] arr = {1, 5, 5, 5, 2};
        int[] result = remove(arr);
        System.out.println(Arrays.toString(result));        // [1, 3, 5, 2]
    }


    public static int[] remove(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ;i<arr.length;i++){
            // If stack is empty or top is not equal to current
            if(stack.isEmpty() || stack.peek()!=arr[i]){
                stack.push(arr[i]);
            }
            else{
                if(i == arr.length-1 || arr[i]!=arr[i+1]){
                    stack.pop();
                }
            }
        }

        // Now transfer to array in correct order
        int[] result = new int[stack.size()];
        for(int i=stack.size() - 1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}