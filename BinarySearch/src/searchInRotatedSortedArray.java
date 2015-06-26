public class searchInRotatedSortedArray {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are
	 * given a target value to search. If found in the array return its index,
	 * otherwise return -1.
	 */

	// Input: sorted rotated array, target. Output: index of the target, if not
	// found return -1
	//	比较A[mid]与A[s],A[e]大小，可确定有序的一边
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int s = 0;
		int e = A.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (A[mid] > A[s]) {
				if (A[s] <= target && target <= A[mid]) {
					e = mid;
				} else {
					s = mid;
				}
			} else {
				if (target >= A[mid] && target <= A[e]) {
					s = mid;
				} else {
					e = mid;
				}
			}
		}
		if (A[s] == target) {
			return s;
		}
		if (A[e] == target) {
			return e;
		}
		return -1;
	}

}
