
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int max = A[0];
		int min = A[0];
		int global = A[0];
		for (int i = 1; i < A.length; i++) {
			int v1 = max * A[i];
			int v2 = min * A[i];
			max = Math.max(A[i], Math.max(v1, v2));
			min = Math.min(A[i], Math.min(v1, v2));
			global = Math.max(global, max);
		}
		return max;
	}
}
