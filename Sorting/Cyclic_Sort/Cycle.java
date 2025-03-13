package Cyclic_Sort;
import java.util.Arrays;
//When range is given from 1 to N use cyclic sort.
public class Cycle {
    public static void main(String[] args) {
        int[] arr={4,1,3,5,2};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycle(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}