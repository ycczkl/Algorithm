public class searchInsertPosition {
	/*
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order. You may assume no duplicates in the array.
	 */
	
	//Input: sorted array without duplicates and duplicates. Output: Index of the position where the target should locate
	//注意边界条件，target可能比A[0]小，比A[A.length-1]大。
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0)
			return 0;
		int s = 0;
		int e = A.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (A[mid] == target) {
				e = mid;
			} else if (A[mid] > target) {
				e = mid;
			} else {
				s = mid;
			}
		}
		if (A[s] >= target) {
			return s;
		} else if (A[e] >= target) {
			return e;
		} else {
			return e + 1;
		}
	}

}
