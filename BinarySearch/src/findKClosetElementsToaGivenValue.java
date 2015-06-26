import java.util.Arrays;

/*
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45

 */

// Sorted array: Binary search.
// Find the pibot element
public class findKClosetElementsToaGivenValue {
	public static int[] findK(int[] A, int x, int k) {		
		if (A == null || A.length <= k)
			return A;
		int[] res = new int[k];
		int l = 0;
		int r = A.length-1;
		while (l+1 < r) {
			int mid = (l+r)/2;
			if (A[mid] == k) {
				r = mid;
			} else if (A[mid] > x) {
				r = mid;
			} else {
				l = mid;
			}
		}
		while (A[l] == x && l > 0)
			l--;
		while (A[r] == x && r < A.length-1)
			r++;
		System.out.println(l+" "+r);
		int count = 0;
		while (count != k) {
			if (l >= 0 && Math.abs(A[l]-x)<=A[r]-x){
				res[count++] = A[l--];				
			} else if (r <= A.length-1 && A[r]-x < Math.abs(A[l]-x)) {
				res[count++] = A[r++];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arg = {12, 16, 22, 30, 35, 39, 42,
	               45, 48, 50, 53, 55, 56};
		System.out.println(Arrays.toString(findK(arg, 35, 4)));
	}
}
