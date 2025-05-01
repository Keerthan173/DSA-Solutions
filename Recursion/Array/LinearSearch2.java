//On multiple occurences

import java.util.ArrayList;

public class LinearSearch2 {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 7, 8,7, 7, 99};
        linear(arr, 7, 0);
        System.out.println(list);           //[2, 4, 5]
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static void linear(int[] arr, int target, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        linear(arr, target, i + 1);
    }
}