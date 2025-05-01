// Square
public class P1 {
    public static void main(String[] args) {
        pattern1(4);
    }
    static void pattern1(int n){
        for(int rows=1;rows<=n;rows++){
            for(int cols=1;cols<=n;cols++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
// Output:
// * * * * 
// * * * *
// * * * *
// * * * *