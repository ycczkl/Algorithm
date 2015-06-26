public class ReverseWordsInaString {
	/*
	 * Given an input string, reverse the string word by word. For example,
	 * Given s = "the sky is blue", return "blue is sky the".
	 */
	// 最直接的方法显然是通过“ ”进行切割再重组，这样空间上会有O(n)的开销。
	// 可以用恢复rotated array或构建rotated array的方法先进行局部翻转，后进行全部翻转。

	public String reverseWords(String s) {
		s = s.trim();
		if (s == null || s.length() == 0)
			return s;
		int start = 0;
		int end = 0;
		StringBuilder sb = new StringBuilder(s);
		while (end < sb.length()) {
			if (sb.charAt(end) != ' ') {
				end++;
			} else {
				if (sb.charAt(end) == sb.charAt(end - 1)) {
					sb.deleteCharAt(end);
				} else {
					reverse(sb, start, end - 1);
					end++;
					start = end;
				}
			}
		}
		reverse(sb, start, end - 1);
		reverse(sb, 0, sb.length() - 1);
		return sb.toString();
	}

	private void reverse(StringBuilder sb, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = sb.charAt(j);
			sb.setCharAt(j, sb.charAt(i));
			sb.setCharAt(i, temp);
		}
	}
	
}
