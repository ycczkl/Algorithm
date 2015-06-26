/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
// 00 30 40 50 60 70 80 90: 无法解析
// 01-09, 27-99(except 30 40 50 60 70 80 90): dp[i] = dp[i-1]
// 10, 20 dp[i] = dp[i-2]
// 11-26:dp[i] = dp[i-1] + dp[i-2]
public class decodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		int dp1 = 1;
		int dp2 = 1;
		int dp3 = 1;
		for (int i = 1; i < s.length(); i++) {
			char preC = s.charAt(i-1);
			char c = s.charAt(i);
			if (c == '0') {
				if (preC == '1' || preC == '2') {
					dp3 = dp1;
				} else {
					return 0;
				}
			} else {
				if (preC == '0' || preC >= '3') {
					dp3 = dp2;
				} else {
					if (preC == '2' && c > '6') {
						dp3 = dp2;
					} else {
						dp3 = dp1 + dp2;
					}
				}
			}
			dp1 = dp2;
			dp2 = dp3;
		}
		return dp3;
    }
	
	//好思考的版本
	public int numDecodings2(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length()+1];
		int first = 1;
		int second = 1;
		for (int i = 1; i < s.length(); i++) {
		    int third = 0;
		    char c = s.charAt(i);
		    char pre = s.charAt(i-1);
		    if (c == '0') {
		        if (pre != '1' && pre != '2')
		            return 0;
		        else {
		            third = first;
		        }
		    } else {
		        int twoNumber = (pre-'0') * 10 + (c-'0');
		        if (twoNumber >= 10 && twoNumber <= 26)
		            third = first + second;
		        else
		            third = second;
		    }
		    first = second;
		    second = third;
		}
		return second;
    }
}
