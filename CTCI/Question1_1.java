//1.ASCII or Unicode?
//2.ASCII only contains 128 character

public class Question1_1 {
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			else {
				char_set[val] = true;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
}
