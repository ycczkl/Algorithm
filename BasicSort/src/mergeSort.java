import java.util.Arrays;


public class mergeSort {
	public static void mergeSortMethod(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		merge(arr, 0 ,arr.length-1);
	}
	private static void merge(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int mid = (l+r)/2;		
		merge(arr, l, mid);
		merge(arr, mid+1, r);
		helper(arr, l, mid ,r);		
	}
	private static void helper(int[] arr, int l, int mid, int r) {
		int[] tmp = new int[r-l+1];
		int i = l;
		int j = mid+1;
		for (int k = 0; k < r - l + 1; k++) {
			if (i > mid)
				tmp[k] = arr[j++];
			else if (j > r)
				tmp[k] = arr[i++];
			else if (arr[i] < arr[j])
				tmp[k] = arr[i++];
			else
				tmp[k] = arr[j++];
		}
		for (int k = l; k <= r; k++) {
			arr[k] = tmp[k-l];
		}
	}
	public static void main(String[] args) {
		int[] arr= {3,43,654,32,4,6,8,9,5,1,2,3,4,5,6,7,8,9,9,6,1,4,3,2,2,9};
		mergeSortMethod(arr);
		System.out.println(Arrays.toString(arr));		
	}
}
