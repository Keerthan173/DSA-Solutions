public class P32 {
    public static void main(String[] args) {
        pattern32(4);
    }
    static void pattern32(int n) {
        int N = 2 * n;
        for (int rows = 1; rows < N; rows++) {
            for (int cols = 1; cols < N; cols++) {
                int valueAtIndex = n - Math.min(Math.min(rows, cols), Math.min(N - rows, N - cols)) + 1;
                System.out.print(valueAtIndex + " ");
            }
            System.out.println();
        }
    }
}
// Output:
// 4 4 4 4 4 4 4 
// 4 3 3 3 3 3 4
// 4 3 2 2 2 3 4
// 4 3 2 1 2 3 4
// 4 3 2 2 2 3 4
// 4 3 3 3 3 3 4
// 4 4 4 4 4 4 4