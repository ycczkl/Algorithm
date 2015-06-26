/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
Example

sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2
sqrt(10) = 3
Challenge

O(log(x))

 */
public class sqrt {
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 0)
        	return -1;
        if (x == 0)
        	return 0;
        int l = 0;
        int r = x;
        int res = 0;
        while (l < r) {
        	int m = (l+r)/2;
        	if (x/m >= m && x/(m+1) <= (m+1))
        		res = m;
        	else if (x/m < m)
        		l = m+1;
        	else
        		r = m-1;
        }
        return res;
    }
}
