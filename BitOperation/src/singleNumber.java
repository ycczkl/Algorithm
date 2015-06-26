/*
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
Example

Given [1,2,2,1,3,4,3], return 4

 */
public class singleNumber {
	public int singleNumber(int[] A) {
		int res = A[0];
		for (int i = 1; i < A.length; i++)
			res = res^A[i];
		return res;
    }
}
