import java.util.Arrays;
import java.util.Collections;


public class quickSort {
	public static void sort(int[] A) {
		helper(A, 0, A.length-1);
	}
	private static void helper(int[] A, int low, int high) {
		if (high <= low) return;
		int j = partition(A, low, high);
		helper(A, low, j-1);
		helper(A, j+1, high);
	}
	private static int partition(int[] A, int low, int high) {
		int index = low + (int)Math.random()*(high - low + 1);
		swap(A, low, index);
		int v = A[low];
		int i = low;
		int j = high+1;
		while (true) {
			while (A[++i] <= v)
				if (i == high)
					break;
			while (A[--j] >= v)
				if (j == low)
					break;
			if (i >= j)
				break;
			swap(A, i, j);
		}
		swap(A, low, j);
		return j;
	}
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	public static void main(String[] args) {
		int[] A = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
