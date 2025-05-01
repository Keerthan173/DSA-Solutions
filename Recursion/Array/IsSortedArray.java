public class IsSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9 };
        // int[] arr={1,3,555,7,9};
        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        return arr[i] <= arr[i + 1] && isSorted(arr, i + 1);
    }
}
