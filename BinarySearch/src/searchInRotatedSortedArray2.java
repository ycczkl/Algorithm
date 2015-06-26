
public class searchInRotatedSortedArray2 {
	// 与1类似，不过有可能出现A[mid] = A[s] = A[e]的情况，这样无法确定有序的一边。所以要先把左边边重复的跳过
	// 例如1233333333， 翻转后可能为312333333 或 33333331233
	// 注意边界条件： A[mid] > A[s], A[mid] < A[s]
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		int s = 0;
		int e = A.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (A[mid] == target)
				return true;
			if (A[mid] > A[s]) {
				if (A[s] <= target && target <= A[mid]) {
					e = mid;
				} else {
					s = mid;
				}
			} else if (A[mid] < A[s]){
				if (target >= A[mid] && target <= A[e]) {
					s = mid;
				} else {
					e = mid;
				}
			} else {
			    s++;
			}
		}
		if (A[s] == target) {
			return true;
		}
		if (A[e] == target) {
			return true;
		}
		return false;
	}
}
