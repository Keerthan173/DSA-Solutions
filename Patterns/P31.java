public class P31 {
    public static void main(String[] args) {
        pattern31(4);
    }

    static void pattern31(int n) {
        int N = 2 * n;
        for (int rows = 1; rows < N; rows++) {
            for (int cols = 1; cols < N; cols++) {
                int valueAtIndex = Math.min(Math.min(rows, cols), Math.min(N - rows, N - cols));
                System.out.print(valueAtIndex + " ");
            }
            System.out.println();
        }
    }
}
// Output:
// 1 1 1 1 1 1 1 
// 1 2 2 2 2 2 1
// 1 2 3 3 3 2 1
// 1 2 3 4 3 2 1
// 1 2 3 3 3 2 1
// 1 2 2 2 2 2 1
// 1 1 1 1 1 1 1
