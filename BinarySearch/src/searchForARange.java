/*
	Given a sorted array of integers, find the starting and ending position of a given target value.
	Your algorithm's runtime complexity must be in the order of O(log n).
I	f the target is not found in the array, return [-1, -1].
 */

public class searchForARange {
	// Input: sorted array and the target. Output:array of starting and ending
	// position
	public int[] searchRange(int[] A, int target) {
		int[] res = { -1, -1 };
		if (A == null || A.length == 0)
			return res;
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
		if (A[s] == target) {
			res[0] = s;
		} else if (A[e] == target) {
			res[0] = e;
		}
		s = 0;
		e = A.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (A[mid] == target) {
				s = mid;
			} else if (A[mid] > target) {
				e = mid;
			} else {
				s = mid;
			}
		}
		if (A[e] == target) {
			res[1] = e;
		} else if (A[s] == target) {
			res[1] = s;
		}
		return res;
	}

}
