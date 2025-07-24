public class MountainPeak {
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,4,3,2};
        int result=peak(arr);
        System.out.println("Peak index:"+result);
    }
    static int peak(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])    //this may be the answer,check left
                end=mid;
            else                       //arr[mid]<arr[mid+1],just look right.Ignore this mid element.
                start=mid+1;
        }
        return start;
    }
}
