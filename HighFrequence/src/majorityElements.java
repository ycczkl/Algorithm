/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class majorityElements {
	//Hash的方法很容易想到，但需要O(n)空间。 用counter计数的方法可以得到O(1)的空间复杂度。
	public int majorityElement(int[] num) {
		int count = 0;
		int major = 0;
		for (int v : num) {
			if (count == 0) {
				count++;
				major = v;
			} else {
				if (major == v) {
					count++;
				} else {
					count--;
				}
			}
		}
		return major;
    }
}
