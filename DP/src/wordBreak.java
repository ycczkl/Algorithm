/*
 *  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
 */
import java.util.*;
public class wordBreak {
	//递推式:http://blog.csdn.net/linhuanmars/article/details/22358863
	//类比此递推式和Unique binary search tree
	//substring并非O（1）操作！！
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i ++) {
			for (int j = 0; j <= i; j++) {
				if (dp[i+1] == true)
					break;
				dp[i+1] = dp[j] && dict.contains(s.substring(j, i+1));
			}
		}
		return dp[s.length()];
    }
	
	//substring不是O(1)操作，所以用删除stringbuilder元素的方法模拟substring操作
	public boolean wordBreak2(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i ++) {
			StringBuilder sb = new StringBuilder(s.substring(0, i+1));
			for (int j = 0; j <= i; j++) {
				if (dp[j] && dict.contains(sb.toString())) {
					dp[i+1] = true;
					break;
				}
				sb.deleteCharAt(0);
			}
		}
		return dp[s.length()];
    }
}
