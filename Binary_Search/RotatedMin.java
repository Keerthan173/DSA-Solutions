public class RotatedMin {
    public static void main(String[] args) {
        int[] arr={4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Minimum value:"+findMin(arr));
    }
    static int findMin(int[] arr){
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[mid]){
                ans=min(ans,arr[start]);
                start=mid+1;
            }
            else{
                ans=min(ans, arr[mid]);
                end=mid-1;
            }
        }
        return ans;
    }
    static int min(int a,int b){
        if(a<b)
            return a;
        return b;
    }
}
