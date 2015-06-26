/*
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

 */
import java.util.*;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int j = 0;
        List<String> res = new ArrayList<String>();
        while (true) {
            int len = 0;
            int count = 0;
            while (j < words.length && count+words[j].length() <= maxWidth) {
                len += words[j].length();
                count += words[j].length()+1;
                j++;
            }
            System.out.println(i+" : "+j);
            StringBuilder sb = new StringBuilder();
            if (j == words.length || j-i-1 == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                }
                while (sb.length() < maxWidth)
                    sb.append(' ');                
            } else {
                int space = (maxWidth-len)/(j-i-1);
                int extra = (maxWidth-len)%(j-i-1);
                for (int k = i; k < j-1; k++) {                	
                    sb.append(words[k]);                    
                    for (int q = 0; q < space; q++)
                        sb.append(' ');
                    if (extra > 0){
                    	sb.append(' ');
                    	extra--;
                    }
                }
                sb.append(words[j-1]);                
            }
            System.out.println(sb.toString());
            res.add(sb.toString());
            i = j;
            if (j == words.length)
            	break;
        }
        return res;
    }
	public static void main(String[] args) {
		String[] words = {"a","b","c","d","e"};
		fullJustify(words, 1);
	}
}
