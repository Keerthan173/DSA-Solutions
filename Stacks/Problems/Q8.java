// Next Smaller Element (to the right)
// Previous Smaller Element (to the left)

// Original:         [10, 5, 12, 3, 7, 4, 1, 3]
// Next Smaller:     [5, 3, 3, 1, 4, 1, -1, -1]
// Previous Smaller: [-1, -1, 5, -1, 3, 3, -1, 1]

package Problems;

import java.util.Arrays;
import java.util.Stack;

public class Q8 {

    static int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1 ; i>=0 ; i--){
            // Remove all greater or equal elements
            while(stack.size()>0 && arr[i]<=stack.peek()){
                stack.pop();
            }
            if(stack.size()==0){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    static int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            // Remove all greater or equal elements
            while(stack.size()>0 && arr[i]<=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 12, 3, 7, 4, 1, 3};
        int [] res1 = nextSmaller(arr); 
        int [] res2 = prevSmaller(arr); 

        System.out.println("Original:         "+ Arrays.toString(arr));
        System.out.println("Next Smaller:     "+ Arrays.toString(res1));
        System.out.println("Previous Smaller: "+ Arrays.toString(res2));
    }
}
