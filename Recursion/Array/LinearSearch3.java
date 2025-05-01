import java.util.ArrayList;

public class LinearSearch3 {
    public static void main(String[] args) {
        int[] arr={3,7,1,7,99,7,2};
        ArrayList<Integer> list=new ArrayList<>();
        linear(arr,7,0,list);
        System.out.println(list);           //[1, 3, 5]
    }
    static ArrayList<Integer> linear(int[] arr,int target,int i, ArrayList<Integer> list){
        if(i==arr.length){
            return list;
        }
        if(arr[i]==target){
            list.add(i);
        }
        return linear(arr, target, i+1, list);
    }
}