/*
 *  
Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 *
 */
//用一个数记录每一位1或0出现的次数。
public class singleNumber2 {
	public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += A[j] >> i & 1;
            }
            if (count % 3 != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
