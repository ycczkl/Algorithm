
public class Question1_8 {
	public static boolean isRotation(String str1, String str2) {
		if(str1.length() == str2.length() && str1.length() > 0) {
			String str1str1 = str1 + str1;
			return isSubstring(str1str1, str2);
		}
		return false;
	}
}
