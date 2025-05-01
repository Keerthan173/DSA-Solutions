public class P28 {
    public static void main(String[] args) {
        pattern28(4);
    }
    static void pattern28(int n) {
        for (int rows = 1; rows < 2 * n; rows++) {
            int totalColInRows = rows > n ? 2 * n - rows : rows;
            int spaceCount=n-totalColInRows;
            for(int s=1;s<=spaceCount;s++){
                System.out.print(" ");
            }
            for (int cols = 1; cols <= totalColInRows; cols++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
// Output:
//    * 
//   * *
//  * * *
// * * * *
//  * * *
//   * *
//    *
