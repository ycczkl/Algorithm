/*
 * Using O(1) time to check whether an integer n is a power of 2.
Example

For n=4, return true

For n=5, return false
Challenge

O(1) time

 */
public class checkPowerOf2 {
	/*
     * @param n: An integer
     * @return: True or false
     */
	//1:1, 2: 10, 4: 100, 8: 1000由此可知2的幂最右位为1其他位为0. (x-1)&x = 0
	//考虑coner case, n = 0 和 n = Integer.MIN_VALUE的情况
    public boolean checkPowerOf2(int n) {
    	return (n==0||n==Integer.MIN_VALUE)?false:((n-1)&n) == 0;
    }
}
