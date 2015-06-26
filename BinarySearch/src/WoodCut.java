/*
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
Example

For L=[232, 124, 456], k=7, return 114.
Note

You couldn't cut wood into float length.
Challenge

O(n log Len), where Len is the longest length of the wood.
*/
public class WoodCut {
	public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0)
            return 0;
        int maxLen = 0;
        for (int n : L) {
            maxLen = Math.max(maxLen, n);
        }
        int l = 1;
        int r = maxLen;
        while(l + 1 < r) {
            int mid = l+(r-l)/2;
            if (getPiece(L, mid) < k)
                r = mid;
            else
                l = mid;
        }
        if (getPiece(L, r) >= k)
            return r;
        else if (getPiece(L, l) >= k)
            return l;
        else
            return 0;
    }
	
    private int getPiece(int[] L, int mid) {
        int pieces = 0;
        for (int n : L)
            pieces += n/mid;
        return pieces;
    }
}
