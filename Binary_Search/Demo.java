public class Demo
{
	public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int target = 6;
        int result = binarySearch(arr, target);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
    
	static int binarySearch(int[] arr,int target)
	{
	    int start=0;
	    int end=arr.length-1;
        boolean isAsecending=arr[start]<arr[end];
	    while(start<=end)
	    {
	        int mid=start+(end-start)/2;
	        if(arr[mid]==target)
	            return mid;
            if(isAsecending){
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