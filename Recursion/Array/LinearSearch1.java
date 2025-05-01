public class LinearSearch1 {
    public static void main(String[] args) {
        int[] arr = { 3, 99, 1, 33, 7 };
        int target = 33;
        System.out.println(linear(arr, target, 0));
    }

    static int linear(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return linear(arr, target, i + 1);
    }
}
