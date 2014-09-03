
public class Question1_5 {
	public static int countCompression(String str) {
		if(str.length() == 0 || str == null) {
			return 0;
		}
		int count = 1, size = 0;
		char last = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;				
			}
			else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		return size;
	}
	
	public static String compress(String str) {
		if(countCompression(str) >= str.length()) {
			return str;
		}
		int count = 1;
		char last = str.charAt(0);
		StringBuffer myStr = new StringBuffer();
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} else {
				myStr.append(last);
				myStr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		myStr.append(last);
		myStr.append(count);
		return myStr.toString();
	}
	
	public static void main(String[] args) {
		String str = "abbccccccde";
		int c = countCompression(str);
		
		String t = compress("abbccccccde");
		System.out.println("Compression: " + t);
		System.out.println("Old String (len = " + str.length() + "): " + str);
		
		System.out.println("Potential Compression: " + c);
	}
}
