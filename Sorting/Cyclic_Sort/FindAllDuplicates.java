package Cyclic_Sort;
//Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
//and each integer appears at most twice, return an array of all the integers that appears twice.

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};  //[3,2]
        // int[] arr={1,1,2};  //[1]
        // int[] arr={1};  //[]
        System.out.println(findDuplicates(arr));
    }
    static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
