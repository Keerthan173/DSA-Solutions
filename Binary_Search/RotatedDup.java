public class RotatedDup {
    public static void main(String[] args) {
        int[] arr={3,3,3,1,2,3,3,3,3};
        int target=1;
        System.out.println(search(arr,target));
    }
    static int search(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            //Edge case
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start=start+1;
                end=end-1;
                continue;
            }
            else if(arr[start]<=arr[mid]){                  
                if(arr[start]<=target && target<arr[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{                                           
                if(arr[mid]<target && target<=arr[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}
