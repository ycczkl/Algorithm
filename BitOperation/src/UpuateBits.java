/*
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)
Example

Given N=(10000000000)2, M=(10101)2, i=2, j=6

return N=(10001010100)2

 */
public class UpuateBits {
	public int updateBits(int n, int m, int i, int j) {
        return (m << i) | (((1 << i) - 1) | ~(-1 >>> (31 - j))) & n;
    }
}
