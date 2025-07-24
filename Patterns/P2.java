// Right-Angled Triangle (Left-Aligned)
class P2Patterns {
    public static void main(String[] args) {
        pattern2(4);
    }
    static void pattern2(int n){
        for(int rows=1;rows<=n;rows++){
            for(int cols=1;cols<=rows;cols++){
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