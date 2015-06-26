/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
 */
//Input: sorted rotated array. Output: the minimal element in array.
//翻转后比较A[mid]与A[s]，如果A[mid] < A[s]则最小值在此区间。 如果A[mid] > A[e],则最小值在此区间。 另外的情况就是标准二分查找了

public class findMinimalInrotatedSortedArray {
	public int findMin(int[] num) {
		if (num == null || num.length == 0)
			return Integer.MIN_VALUE;
		int s = 0;
		int e = num.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (num[mid] < num[s]) {
				e = mid;
			} else if (num[mid] > num[e]) {
				s = mid;
			} else {
				e = mid;
			}
		}
		return num[s] < num[e] ? num[s] : num[e];
	}

}
