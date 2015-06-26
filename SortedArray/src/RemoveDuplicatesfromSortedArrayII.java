public class RemoveDuplicatesfromSortedArrayII {
	/*
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice? For example, Given sorted array A = [1,1,1,2,2,3], Your function
	 * should return length = 5, and A is now [1,1,2,2,3].
	 */
	// Input: Sorted array with duplicate. Output: array whith at most two
	// duplicate and the length of array.
	// 此题需要考虑的非常仔细。 需要思考的是什么时候res指针才会移动？ 一个是当A[i] == A[i-1] && count <
	// 2，也就是第一次二个相同数字出现的时候。 一个是A[i] != A[i-1]的时候。 其他时候res指针不变。
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int count = 1;
		int res = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1] && count < 2) {
				A[res++] = A[i];
				count++;
			} else if (A[i] > A[i - 1]) {
				A[res++] = A[i];
				count = 1;
			}
		}
		return res;
	}

}
