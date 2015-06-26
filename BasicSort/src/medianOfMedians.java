import java.util.Arrays;


public class medianOfMedians {
	public static int findMedian(int[] A) {
		int median = A.length % 2 == 0 ? A.length / 2 - 1 : A.length / 2;
		helper(median, A, 0, A.length-1);
		return A[median];
	}
	private static void helper(int median, int[] A, int low, int high) {
		if (low >= high) return;
		int j = partition(A, low, high);
		int length = j - low + 1;
		if (j == median)
			return;
		if (j < median)
			helper(median,A, low, j-1);
		else 
			helper(median,A, j+1, high);
	}
	private static int partition(int[] arr, int low, int high) {
		int pivotValue = getPivot(arr, low, high);
		System.out.println(pivotValue);
		int i = low-1;
		int j = high+1;
		while (true) {
			System.out.println("i: "+i+" "+"j:"+j);
			while (arr[++i] <= pivotValue) 
				if (i == high)
					break;
			while (arr[--j] > pivotValue)
				if (j == low)
					break;
			if (i >= j){
				System.out.println("here");
				break;
			}
			swap(arr, i, j);
		}
		System.out.println(Arrays.toString(arr));
		return j;
	}
	private static int getPivot(int[] A, int low, int high) {
		if (A.length <= 9) {
			Arrays.sort(A);
			return A.length%2 == 0 ? A[A.length/2-1] : A[A.length/2];
		}
		
		int[] temp = null;
		int[] medians = new int[(int)Math.ceil((double)(high - low + 1)/5)];
		int medianIndex = 0;
		
		while (low <= high) {
			temp = new int[Math.min(5, high-low+1)];
			for (int i = 0; i < temp.length && low <= high; i++) {
				temp[i] = A[low++];
			}
			Arrays.sort(temp);
			
			medians[medianIndex++] = temp[temp.length/2];
		}
		
		return getPivot(medians, 0, medians.length-1);
	}
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	// Median of Medians Algorithm, Time complexity: O(n)  
//    public static int findKthSmallest(int[] A, int k) {  
//        int value = 0;  
//        int n = A.length;  
//        int c = 5;      // Constant used to divide the array into columns  
//  
//        while (true) {  
//            // Extract median of medians and take it as the pivot  
//            int pivot = findPivot(A, n, c);  
//  
//            // Now count how many smaller and larger elements are there  
//            int smallerCount = 0;  
//            int largerCount = 0;  
//  
//            int[] data = new int[2];  
//  
//            // CountElements(a, n, pivot, out smallerCount, out largerCount);  
//            CountElements(A, n, pivot, data);  
//  
//            smallerCount = data[0];  
//            largerCount = data[1];  
//  
//            // Finally, partition the array  
//            if (k < smallerCount) {  
//                n = Partition(A, n, pivot, true);  
//            } else if (k < n - largerCount) {  
//                value = pivot;  
//                break;  
//            } else {  
//                k -= n - largerCount;  
//                n = Partition(A, n, pivot, false);  
//            }  
//        }  
//        return value;  
//    }  
//  
//    private static int findPivot(int[] A, int n, int c) {  
//        while (n > 1) {  
//            int pos = 0;  
//            int tmp = 0;  
//  
//            for (int start = 0; start < n; start += c) {  
//                int end = start + c;  
//                if (end > n){    // Last column may have  
//                    end = n;    // less than c elements  
//                }  
//                  
//                // Sort the column  
//                for (int i = start; i < end - 1; i++){  
//                    for (int j = i + 1; j < end; j++){  
//                        if (A[j] < A[i]) {  
//                            tmp = A[i];  
//                            A[i] = A[j];  
//                            A[j] = tmp;  
//                        }  
//                    }  
//                }  
//  
//                // Pick the column's median and promote it  
//                // to the beginning of the array  
//                end = (start + end) / 2; // Median position  
//                tmp = A[end];  
//                A[end] = A[pos];  
//                A[pos++] = tmp;  
//  
//            }  
//            n = pos; // Reduce the array and repeat recursively  
//        }  
//  
//        return A[0]; // Last median of medians is the pivot  
//    }  
//  
//    // static void CountElements(int[] a, int n, int pivot, out int  
//    // smallerCount, out int largerCount)  
//    private static void CountElements(int[] a, int n, int pivot, int[] values) {  
//        for (int i = 0; i < n; i++) {  
//            if (a[i] < pivot)  
//                values[0]++;  
//            if (a[i] > pivot)  
//                values[1]++;  
//        }  
//    }  
//  
//    private static int Partition(int[] a, int n, int pivot, boolean extractSmaller) {  
//        int pos = 0;  
//        for (int i = 0; i < n; i++) {  
//            if ((extractSmaller && a[i] < pivot)  
//                    || (!extractSmaller && a[i] > pivot)) {  
//                int tmp = a[i];  
//                a[i] = a[pos];  
//                a[pos++] = tmp;  
//            }  
//        }  
//        n = pos;  
//        return n;  
//    }  
	public static void main(String[] args) {
		
		int[] arr = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
		//Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		System.out.println(findMedian(arr));
		
	}
}
