package Cyclic_Sort;

import java.util.ArrayList;
import java.util.List;

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array 
// of all the integers in the range [1, n] that do not appear in nums.
public class NumbersDiappeared {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};  //[5, 6]
        // int[] arr={1,1};  //[2]
        System.out.println(findDisappearedNumbers(arr));
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){       // If the number is not at its correct index
                list.add(i+1);      // The missing number is (index + 1)
            }
        }
        return list;        // Return the list of missing numbers
    }

    static void swap(int[] nums,int first,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
