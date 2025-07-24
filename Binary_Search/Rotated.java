public class Rotated {
    public static void main(String[] args) {
        int[] arr={7,8,9,0,1,2,3,5,6};
        int target=0;
        System.out.println(search(arr,target));
    }
    static int search(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            //Identify which part is sorted and check whether target is in range
            else if(arr[start]<=arr[mid]){                  //If left is sorted
                if(arr[start]<=target && target<arr[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{                                           //Right is sorted
                if(arr[mid]<target && target<=arr[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}
