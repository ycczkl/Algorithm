//二分法，logn时间复杂度
public class Pow {
	public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double half = myPow(x, n/2);
        if (n%2 == 0) {
            return half*half;
        } else {
            return n > 0 ? x*half*half : half/x*half;
        }
    }
}
