import java.util.ArrayList;
import java.util.Arrays;

/*
 * Find K-th largest element in an array.
 Note

 You can swap elements in the array
 Example

 In array [9,3,2,4,8], the 3rd largest element is 4

 In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 Challenge

 O(n) time, O(1) space

 */
//问题转换成求第 size - k + 1小得元素。 快排的变体。 
public class KthLargestElement {
	// param k : description of k
	// param numbers : array of numbers
	// return: description of return
	public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
		k = numbers.size() - k + 1;
		helper(k, numbers, 0, numbers.size() - 1);
		return numbers.get(k - 1);
	}

	private static void helper(int k, ArrayList<Integer> numbers, int low, int high) {
		if (low >= high)
			return;
		int j = partition(numbers, low, high);
		if (j == k - 1)
			return;
		if (j < k - 1)
			helper(k, numbers, j + 1, high);
		else
			helper(k, numbers, low, j - 1);
	}

	private static int partition(ArrayList<Integer> numbers, int low, int high) {
		int index = low + (int) Math.floor(Math.random() * (high - low + 1));
		swap(numbers, low, index);
		int v = numbers.get(low);
		int i = low;
		int j = high + 1;
		while (true) {
			while (numbers.get(++i) < v)
				if (i == high)
					break;
			while (numbers.get(--j) > v)
				if (j == low)
					break;
			if (i >= j)
				break;
			swap(numbers, i, j);
		}
		swap(numbers, low, j);
		return j;
	}

	private static void swap(ArrayList<Integer> numbers, int i, int j) {
		int tmp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j, tmp);
	}
	public static void main(String[] args) {
		int[] a = {9,3,2,4,8};
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(9);
		arr.add(3);
		arr.add(2);
		arr.add(4);
		arr.add(8);
		System.out.println(kthLargestElement(3, arr));
	}
}
