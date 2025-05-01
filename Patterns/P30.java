public class P30 {
    public static void main(String[] args) {
        pattern30(5);
    }
    static void pattern30(int n) {
        for (int rows = 1; rows <= n; rows++) {
            for(int s=1;s<=n-rows;s++){
                System.out.print("  ");
            }
            for (int cols = rows; cols >=1; cols--) {
                System.out.print(cols+" ");
            }
            for (int cols = 2; cols <= rows; cols++) {
                System.out.print(cols+" ");
            }
            System.out.println();
        }
    }
}
// Output:
//         1 
//       2 1 2
//     3 2 1 2 3
//   4 3 2 1 2 3 4
// 5 4 3 2 1 2 3 4 5