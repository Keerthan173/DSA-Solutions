public class MountainArray {
    public static void main(String[] args) {
        int[] arr={0,1,3,4,5,7,6,5,2,1};
        int target=2;
        System.out.println(search(arr,target));
    }
    static int search(int[] arr,int target){
        int peakIndex=peak(arr);
        int left=orderAgnostic(arr,target,0,peakIndex);
        if(left!=-1)
            return left;
        return orderAgnostic(arr,target,peakIndex+1,arr.length-1);
    }
    static int peak(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1])
                start=mid+1;
            else
                end=mid;
        }
        return start;
    }
    static int orderAgnostic(int[] arr,int target,int start,int end){
        boolean isAscending=arr[start]<arr[end];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==arr[mid])
                return mid;
            if(isAscending){
                if(target<arr[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(target<arr[mid])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}
