
public class findKthNumberOfTwoSortedArray {
	public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
		if (A_start >= A.length) {
			return B[B_start+k-1];
		}
		if (B_start >= B.length) {
			return A[A_start+k-1];
		}
		if (k == 1)
			return Math.min(A[A_start], B[B_start]);
		int A_key = A_start + k/2 - 1 < A.length ? A[A_start+k/2-1] : Integer.MAX_VALUE; 
		int B_key = B_start + k/2 - 1 <	B.length ? A[B_start+k/2-1] : Integer.MAX_VALUE;
		if (A_key > B_key) {
			return findKth(A, A_start, B, B_start+k/2, k-k/2);
		} else {
			return findKth(A, A_start+k/2, B, B_start, k-k/2);
		}
	}
	public static void main(String[] args) {
		int[] a = {2,3,6,7,9};
		int[] b = {4,5,6,6,8,8,8,9};
		System.out.println(findKth(a, 0, b, 0, 4));
	}
}
