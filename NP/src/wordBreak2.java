/*
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
 */
import java.util.*;

public class wordBreak2 {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return res;
		helper(s, 0, new StringBuilder(), dict, res);
		return res;
    }
	private void helper(String s, int start, StringBuilder sb,Set<String> dict, List<String> res) {
		if (start > s.length()) {
			res.add(sb.toString());
			return;
		}
		StringBuilder item = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			item.append(s.charAt(i));
			if (dict.contains(item.toString())) {
				if (item.length() != 0)
					sb.append(" ");
				sb.append(item);
				helper(s, i+1, sb, dict, res);
			}
		}
	}
}
