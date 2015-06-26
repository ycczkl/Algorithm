/*
 * Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.
Example

Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]
 */
public class RemoveElement {
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    //Use two pointer, one from the head and one from the tail.
    //Corner case: [0,0,0,0,0], 0, [], null
    //Time complexity: O(n), Space complexity: O(1)
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;
        int p1 = 0;
        int p2 = A.length-1;
        while (p1 < p2) {
            while (p2 >= 0  && A[p2] == elem)
                p2--;
            while (p1 < A.length && A[p1] != elem)
                p1++;
            if (p1 < p2) {
                int tmp = A[p1];
                A[p1] = A[p2];
                A[p2] = tmp;
            }
        }
        return p2+1;
    }
}
