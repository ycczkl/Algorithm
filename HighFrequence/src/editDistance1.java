/*
 * Three operation, insert, delete and replace.
 * Check if you can change word1 to word2 in one operation.
 */
public class editDistance1 {
	public static boolean checkWord(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || Math.abs(s1.length()-s2.length())>1)
			return false;
		boolean equalLen = true;
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		if (s1.length() != s2.length()) {
			equalLen = false;
			if (sb1.length() < sb2.length())
				sb1.append(' ');
			else
				sb2.append(' ');
		}
		
		int len = s1.length() >= s2.length() ? s1.length(): s2.length();
		boolean changed = false;
		for (int i = 0; i < len; i++) {
			if (sb1.charAt(i) != sb2.charAt(i)) {
				if (changed)
					return false;
				else {
					if (equalLen)
						sb1.setCharAt(i, sb2.charAt(i));					
					else {
						if (s1.length() > s2.length())
							sb2.insert(i, sb1.charAt(i));
						else
							sb1.insert(i, sb2.charAt(i));
					}
					changed = true;
				}
			}
		}
		return true;
	}
	public static void main(String args[]) {
		System.out.println(checkWord("word1","word"));
		System.out.println(checkWord("word1","word2"));
		System.out.println(checkWord("word1","wrd1"));
	}
}
