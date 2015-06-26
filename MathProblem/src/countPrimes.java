import java.util.Arrays;
/*
 * Count the number of prime numbers less than a non-negative number, n
 */

//Sieve of Eratosthenes method
public class countPrimes {
	public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int i = 2;
        while (i < Math.ceil((double)n/i)) {
        	
            for (int j = i; j*i < n; j++) {
                if (!prime[j*i]) {
                    prime[j*i] = true;
                }
            }
            i++;
            while (prime[i])
                i++;
        }
        int res = 0;
        for(int j = 2; j < n; j++) {
            if (!prime[j])
                res++;
        }
        return res;
    }
	public static void main(String[] args) {
		countPrimes(5);
	}
}
