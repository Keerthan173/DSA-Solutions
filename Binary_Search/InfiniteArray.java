//Cannot use length of array
public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr={2,5,6,9,13,15,18,21,25,27,28,30,33,35,38,39,41};
        int target=28;
        System.out.println(search(arr,target));
    }
    static int search(int[] arr,int target){
        int start=0;
        int end=1;
        while (target>arr[end]) {
            int temp=end+1;
            end=end+2*(end-start+1);
            start=temp;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr,int target,int start,int end)
	{
	    while(start<=end)
	    {
	        int mid=start+(end-start)/2;
	        if(arr[mid]==target)
	            return mid;
            else if(target<arr[mid])
                end=mid-1;
            else
                start=mid+1;
	    }
	    return -1;
	}
}
