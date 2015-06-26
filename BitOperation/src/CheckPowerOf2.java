/*
 * Using O(1) time to check whether an integer n is a power of 2.
Example

For n=4, return true;

For n=5, return false;
Challenge

O(1) time
 */

public class CheckPowerOf2 {
	public boolean checkPowerOf2(int n) {
        return (n==0||n==Integer.MIN_VALUE)?false:((n-1)&n) == 0;
    }
}
