import java.util.ArrayList;

public class mergeSortedArray {
	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array. Note: You may assume that A has enough space (size that is greater
	 * or equal to m + n) to hold additional elements from B. The number of
	 * elements initialized in A and B are m and n respectively.
	 */
	// 从后向前merge, 注意b有可能在循环后有剩余的情况。

	public void merge(int[] A, int m, int[] B, int n) {
		if (A == null || B == null || A.length == 0 || B.length == 0)
			return;
		int i = m + n - 1;
		m = m - 1;
		n = n - 1;
		while (m >= 0 && n >= 0) {
			if (A[m] >= B[n]) {
				A[i--] = A[m--];
			} else {
				A[i--] = B[n--];
			}
		}
		while (n >= 0) {
			A[i--] = B[n--];
		}
	}
	
	 /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> large = A.size() >= B.size() ? A : B;
        ArrayList<Integer> small = A.size() >= B.size() ? B : A;
        int m = large.size()-1;
        int n = small.size()-1;
        while (m >= 0 && n >= 0) {
            if (large.get(m) >= small.get(n)) {
                m--;
            } else {
                large.add(m+1, small.get(n--));
            }
        }
        while (n >= 0) {
            large.add(0, small.get(n--));
        }
        return large;
    }

}
