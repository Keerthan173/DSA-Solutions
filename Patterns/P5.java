public class P5 {
    public static void main(String[] args) {
        pattern5(5);
    }

    static void pattern5(int n) {
        for (int rows = 1; rows < 2 * n; rows++) {
            int totalColInRows = rows > n ? 2 * n - rows : rows;
            for (int cols = 1; cols <= totalColInRows; cols++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
// Output:
// * 
// * *
// * * *
// * * * *
// * * * * *
// * * * *
// * * *
// * *
// *