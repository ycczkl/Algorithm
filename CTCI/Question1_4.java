//1.space O(1). replace from back to front
public class Question1_4 {
	public static void replaceSpaces(char[] str, int length) {
		int count = 0;
		for(int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				count++;
			}
		}
		int newLength = length + count * 2;
		str[newLength] = '\0';
		for(int i = length - 1 ; i >= 0 ; i --) {
			if(str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else {
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
	}
	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());	
		System.out.println(String.valueOf(arr));
	}
}
