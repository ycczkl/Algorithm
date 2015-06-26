/*
 * Determine the number of bits required to convert integer A to integer B 
Example

Given n = 31, m = 14,return 2

(31)10=(11111)2

(14)10=(01110)2

 */
public class ConvertIntegerAtoIntegerB {
	public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += c & 1;
            c = c >>> 1;
        }
        return count;
    }
	public static void main(String[] args) {
		System.out.println(~0 == -1);
	}
}
