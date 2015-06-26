
public class IntToBinary {
	public static String intToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		while(n != 0) {
			sb.insert(0,n%2);
			n /= 2;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(intToBinary(21));
	}
}
