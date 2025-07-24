import java.util.Scanner;
public class Ceiling {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the target:");
        int target=in.nextInt();
        int result=ceil(arr,target);
        if(result==-1)
            System.out.println("Ceiling not found.");
        else
            System.out.println("Ceiling:"+arr[result]);
        in.close();
    }
    static int ceil(int[] arr,int target)
	{
	    int start=0;
	    int end=arr.length-1;
        if(target>arr[end])
            return -1;
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
	    return start;
	}
}
