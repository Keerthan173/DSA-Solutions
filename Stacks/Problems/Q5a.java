// Next Greater Element to the Right
// The next greater element for an element x is the first element to the right of x that is greater than x.
// If no such element exists, assign -1.

// Input   : arr =  {10, 6, 6,  8, 12,  4, 1,  3}
// Expected Output: [12, 8, 8, 12, -1, -1, 3, -1]



package Problems;

import java.util.Arrays;

public class Q5a {


    public static void main(String[] args) {
        int[] arr = { 10, 6, 6, 8, 12, 4, 1, 3 };
        int[] res = new int[arr.length];

        for(int i=0 ; i<arr.length-1 ; i++){
            res[i] = -1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        res[arr.length-1] = -1;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)