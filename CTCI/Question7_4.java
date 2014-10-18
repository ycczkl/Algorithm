
public class Question7_4 {
	
	//Substraction
	public static int negate(int b) {
		int ne = 0;
		int d = (b < 0) ? 1 : -1;
		while(b != 0) {
			ne += d;
			b += d;
		}
		return b;
	}
	public static int substraction (int a, int b) {
		return a + negate(b);
	}
	
	//Mul
	public static int mul(int a, int b) {
		if (a < b) {
			return mul(b,a);
		}
		int sum = 0;
		
		for (int i = negate(b); i > 0; i--) {
			sum += a;
		}
		if (b < 0) {
			sum = negate(sum);
		}
		return sum;
	}
}
