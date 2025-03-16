package Cyclic_Sort;
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={3,0,1};  //2
        // int[] arr={0,1};  //2
        // int[] arr={9,6,4,2,3,5,7,0,1};  //8
        System.out.println(missing(arr));

    }
    static int missing(int[] arr){
        // Step 1: Apply Cyclic Sort to place numbers in their correct positions
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]){      //arr[i] < arr.length is necessary to avoid an ArrayIndexOutOfBoundsException.The array contains numbers in the range [0, n].
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
        // Step 2: Identify the missing number
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index){
                return index;
            }
        }
        return arr.length; // Return n if all numbers from 0 to n-1 are present
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}