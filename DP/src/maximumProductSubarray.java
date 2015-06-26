/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
 */
public class maximumProductSubarray {
	public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int localMax = A[0];
        int localMin = A[0];
        int globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            int v1 = A[i] * localMax;
            int v2 = A[i] * localMin;
            localMax = Math.max(A[i], Math.max(v1, v2));
            localMin = Math.min(A[i], Math.min(v1, v2));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
