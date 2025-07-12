/* Substrings is continuous characters in a string.(Subset is not same)

str = "abcd"

a
ab
abc
abcd
b
bc
bcd
c
cd
d

*/

public class File04_AllSubstrings {
    public static void main(String[] args) {
        String str = "abcd";
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i, j));
            }
        }
    }
}
