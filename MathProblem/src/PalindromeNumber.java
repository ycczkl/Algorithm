
public class PalindromeNumber {
	//corner case: overflow, if negative can be palidrome.
    //掐头去尾法
	public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int base = 1;
        while (x/10 >= base) {
            base *= 10;
        }
        while (x > 0) {
            int l = x%10;
            int r = x/base;
            System.out.println(l + " "+r);
            if (l == r) {
                x -= r*base;
                x /= 10;
                base /= 100;
            } else {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
}
