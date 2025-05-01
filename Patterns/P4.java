public class P4 {
    public static void main(String[] args) {
        pattern4(4);
    }
    static void pattern4(int n){
        for(int rows=1;rows<=n;rows++){
            for(int cols=1;cols<=rows;cols++){
                System.out.print(cols+" ");
            }
            System.out.println();
        }
    }
}
// Output:
// 1 
// 1 2
// 1 2 3
// 1 2 3 4