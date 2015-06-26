import java.util.Arrays;

//适用于n个0到k得整数排序(桶排序？)
public class countingSort {
	public static int[] countingSort(int[] A) {
		sort(A);
		return A;
	}
	private static void sort(int[] A) {
		int min = 0;
		int max = 0;
		for (int n : A) {
			min = Math.min(n, min);
			max = Math.max(max, n);
		}
		
		int[] count = new int[max-min+1];		
		for (int n : A) {
			count[n-min]++;
		}
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i]-- > 0)
				A[index++] = i+min;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,0,3,1,0,1,1};
		System.out.println(Arrays.toString(countingSort(A)));
		
	}
}
