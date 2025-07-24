public class StartEndPosition {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,9};
        int target=8;
        int[] result=searchRange(arr,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
    static int[] searchRange(int[] arr,int target){
        int[] result={-1,-1};
        result[0]=search(arr,target,true);
        if(result[0]!=-1)
            result[1]=search(arr,target,false);
        return result;
    }
    static int search(int[] arr,int target,boolean firstOccurrence){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==arr[mid]){
                ans=mid;
                if(firstOccurrence)
                    end=mid-1;
                else
                    start=mid+1;
            }
            else if(target<arr[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return ans;
    }
}