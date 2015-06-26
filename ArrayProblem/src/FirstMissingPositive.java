/*
 * Given an unsorted integer array, find the first missing positive integer.
Example

Given [1,2,0] return 3, and [3,4,-1,1] return 2.
Challenge

Your algorithm should run in O(n) time and uses constant space.

 */
public class FirstMissingPositive {
	/**    
     * @param A: an array of integers
     * @return: an integer
     */
    //Use the idea of counting sort: iterate the array, if n <= 0 || n > arr.length
    //remain n in his position. If not switch n with the value of index n.
    //Corner case: null, [], [1,2,3,4] return 5
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i]-1]) {
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
                i--;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1)
                return i+1;
        }
        return A.length+1;
    }
}
