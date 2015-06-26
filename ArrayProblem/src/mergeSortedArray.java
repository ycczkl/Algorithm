/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
Example

A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]
Note

You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

 */
public class mergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    //Two pointer: from back to front
    //corner case: A == null or B == null or B.length == 0, m ran out first, n ran out first
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null || A.length < B.length || B.length == 0)
            return;
        int p = m + n -1;
        m--;
        n--;
        while (p >= 0) {
            if (m >= 0 && n >= 0) {
                if (A[m] >= B[n]) {
                    A[p--] = A[m--];
                } else {
                    A[p--] = B[n--];
                }
            } else if (m < 0) {
                A[p--] = B[n--];
            } else if (n < 0) {
                return;
            }
        }
    }
}
