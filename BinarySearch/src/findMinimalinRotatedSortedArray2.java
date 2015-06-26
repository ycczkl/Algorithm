/*
 * 相比于1，此题只需加入判断遇到重复的情况就可以：左移一位。
 */
public class findMinimalinRotatedSortedArray2 {
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
			} else if (num[s] == num[mid] && num[mid] == num[e]) {
			    s++;  
			} else {
				e = mid;
			}
		}
		return num[s] < num[e] ? num[s] : num[e];
	}
}
