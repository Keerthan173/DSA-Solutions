public class P17 {
    public static void main(String[] args) {
        pattern17(4);
    }
    static void pattern17(int n) {
        for (int rows = 1; rows < 2*n; rows++) {
            int totalColsInRows = rows>n ? 2*n - rows : rows;
            for(int s=1;s<=n-totalColsInRows;s++){
                System.out.print("  ");
            }
            for (int cols = totalColsInRows; cols >=1; cols--) {
                System.out.print(cols+" ");
            }
            for (int cols = 2; cols <= totalColsInRows; cols++) {
                System.out.print(cols+" ");
            }
            System.out.println();
        }
    }
}
// Output:
//       1
//     2 1 2
//   3 2 1 2 3
// 4 3 2 1 2 3 4
//   3 2 1 2 3
//     2 1 2
//       1