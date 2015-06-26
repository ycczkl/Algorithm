public class searchA2DMatrix {
	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties: Integers in each row
	 * are sorted from left to right. The first integer of each row is greater
	 * than the last integer of the previous row
	 */

	// Input: 2D matrix，each row is sorted and first integer of each row is
	// greater than the last integer of the previous row. The target. Output:
	// Boolean, if the target is exits in the 2D array.
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int cLen = matrix[0].length;
		int rLen = matrix.length;
		int s = 0;
		int e = rLen - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (matrix[mid][0] == target) {
				e = mid;
			} else if (matrix[mid][0] > target) {
				e = mid;
			} else {
				s = mid;
			}
		}
		int rowN = -1;
		if (matrix[s][0] <= target && target < matrix[e][0]) {
			rowN = s;
		} else if (target >= matrix[e][0]
				&& target <= matrix[rLen - 1][cLen - 1]) {
			rowN = e;
		} else {
			return false;
		}
		s = 0;
		e = cLen - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (matrix[rowN][mid] == target) {
				e = mid;
			} else if (matrix[rowN][mid] > target) {
				e = mid;
			} else {
				s = mid;
			}
		}
		return (matrix[rowN][s] == target || matrix[rowN][e] == target)  ? true : false;
	}
	
	public boolean searchMatrixOnce(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int cLen = matrix[0].length;
		int rLen = matrix.length;
		int s = 0;
		int e = cLen * rLen - 1;
		while (s+1<e) {
			int mid = (s+e)/2;
			if (matrix[mid/cLen][mid%cLen] == target) {
				return true;
			} else if (matrix[mid/cLen][mid%cLen] > target) {
				e = mid;
			} else {
				s = mid;
			}
		}
		if (matrix[s/cLen][s%cLen] == target) {
			return true;
		} else if (matrix[e/cLen][e%cLen] == target) {
			return true;
		} else {
			return false;
		}
	}

}
