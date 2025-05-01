public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9,1,2,3};
        // int[] arr={5,6,1,2,3,4};
        System.out.println(search(arr,2,0,arr.length-1));
    }
    static int search(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;      // Base case: target not found
        }
        int mid=start + (end-start)/2;
        if(arr[mid]==target){
            return mid;
        }

        // Check if left half is sorted
        if(arr[start]<=arr[mid]){
            // Check if target lies in the left half
            if(target>=arr[start] && target<=arr[mid]){
                return search(arr, target, start, mid-1);
            }else{
                return search(arr, target, mid+1, end);     // Search in right half
            }
        }

        // Otherwise, right half must be sorted
        if(target>=arr[mid] && target<=arr[end]){
            return search(arr, target, mid+1, end);     // Search in right half
        }

        return search(arr, target, start, mid-1);       // Search in left half
    }
}