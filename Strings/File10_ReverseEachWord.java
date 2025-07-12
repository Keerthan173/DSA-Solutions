// Leetcode 557: Reverse Words in a String III
// https://leetcode.com/problems/reverse-words-in-a-string-iii/

// Problem: Reverse each word in a given string while maintaining the order of the words.
// Input:  "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"


public class File10_ReverseEachWord {
    public static void main(String[] args) {
        String str = "I'm Keerthan K from Mangaluru";
        String res = reverseWords(str);
        System.out.println(res);        // m'I nahtreeK K morf urulagnaM
    }

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();   // To store the final result
        StringBuilder temp = new StringBuilder();  // To build and reverse individual words

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If not space, keep building the word
            if(ch != ' ') {
                temp.append(ch);
            } else {
                // Space encountered — reverse current word and append to result
                temp.reverse();                         // Reverse the current word
                ans.append(temp).append(" ");           // Add reversed word + space to result
                temp.setLength(0);                      // Clear temp for next word
            }
        }

        // After the loop, handle the last word (no space after it)
        temp.reverse();                     // Reverse last word
        ans.append(temp);                   // Append it to result

        return ans.toString();
    }
}
