
public class Question5_5 {
	public static int swapOddEven(int n) {
		return (((n & (0xaaaaaaaa)) >> 1) | (n & (0x55555555) << 1));
	}
}
