// Inverted left-aligned right-angled triangle
public class P3 {
    public static void main(String[] args) {
        pattern3(4);
    }
    static void pattern3(int n){
        for(int rows=1;rows<=n;rows++){
            for(int cols=1;cols<=n-rows+1;cols++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
//Output:
// * * * * 
// * * * 
// * * 
// *