
public class Question5_1 {
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}
	
	public static int updatebits(int n, int m, int i, int j) {
		if (i >= 32 || j < i) {
			return 0;
		}
		
		int allOnes = ~0;
		
		int left = allOnes << (j + 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		
		int n_cleared = n & mask;
		int m_shifted = m << i;
		
		return n_cleared | m_shifted;
	}
	public static void main(String args[]) {
		int a = 103217;
		System.out.println(toFullBinaryString(a));
		int b = 13;
		System.out.println(toFullBinaryString(b));		
		int c = updatebits(a, b, 4, 12);
		System.out.println(toFullBinaryString(c));
	}
}
