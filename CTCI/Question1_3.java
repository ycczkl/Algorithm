//1.ASCII or unicode? Always remenber the size of the character size.
//2. If can contains space?
public class Question1_3 {
	public static boolean permutation(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		int letters[] = new int[256]; //Assumption
		for(int i = 0; i < str1.length(); i++) {
			int letter = str1.charAt(i);
			letters[letter]++;
		}
		for(int i = 0; i < str2.length(); i++) {
			int letter = str2.charAt(i);
			--letters[letter];
			if(letters[letter] < 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]) {
		String[][] pairs = {{"apple","papel"},{"carrot","tarroc"},{"hello","llloh"}};
		for(String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean result = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + result);
		}
	}
}
