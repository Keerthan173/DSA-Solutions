import java.util.Scanner;
public class Flooring {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the target:");
        int target=in.nextInt();
        int result=floor(arr,target);
        if(result==-1)
            System.out.println("Floor not found.");
        else
            System.out.println("Floor:"+arr[result]);
        in.close();
    }
    static int floor(int[] arr,int target)
	{
	    int start=0;
	    int end=arr.length-1;
        if(target<arr[0])
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
	    return end;
	}
}
