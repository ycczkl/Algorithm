import java.util.*;
/*
 *
 * Calculate the an % b where a, b and n are all 32bit integers.
Example

For 231 % 3 = 2

For 1001000 % 1000 = 0
Challenge

require: O(logn)

 */
public class fastPower {
	/*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
	//(a + b) % p = (a % p + b % p) % p
	//Even: (a^2n)%b = (a^n%b * a^n%b)%b
	//Odd: (a^2n+1)%b = ((a^n%b * a^n%b)%b * a%b)%b
	public int fastPower(int a, int b, int n) {
        if (n <= 1)
        	return (int)Math.pow(a, n)%b;
        long half = fastPower(a,b,n/2);
        if (n % 2 == 0) {        	
        	return (int)((half * half) % b);
        }
        else {
        	long multi = half * half;
        	return (int)((((half * half) % b) * (a % b)) % b);
        }
    }
}
