import java.util.ArrayList;

public class LinearSearch4 {
    public static void main(String[] args) {
        int[] arr={3,7,1,7,99,7,2};
        System.out.println(linear(arr,7,0));
    }
    static ArrayList<Integer> linear(int[] arr,int target,int i){
        ArrayList<Integer> list= new ArrayList<>();
        if(i==arr.length){
            return list;
        }
        if(arr[i]==target){
            list.add(i);
        }
        list.addAll(linear(arr, target, i+1));      //Add
        return list;
    }
}