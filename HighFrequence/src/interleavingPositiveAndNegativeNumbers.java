import java.util.Arrays;

/*
 * Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Note
You are not necessary to keep the original order or positive integers or negative integers.

Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.

Challenge
Do it in-place and without extra memory.
 */

//Two pointer, from head to tail
public class interleavingPositiveAndNegativeNumbers {
	public static int[] rerange(int[] A) {
		if (A == null || A.length <= 2)
			return A;
		int pos = 0;
		int neg = 0;
		for (int v : A) {
			if (v < 0)
				neg++;
			else
				pos++;
		}
		pos = pos >= neg ? 0 : 1;
		neg = pos == 0 ? 1 :0;
		while (pos < A.length && neg < A.length) {
			if (A[pos] > 0)
				pos += 2;
			else if (A[neg] < 0)
				neg += 2;
			else
				swap(A, pos, neg);
		}
		return A;
	}
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	public static void main(String[] args) {
		int[] a = {-1,-1,-2,-2,-6,-9,-2,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(rerange(a)));
	}
}
