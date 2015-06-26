import java.util.*;
/*
 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
Example

Given [1,2,2,3,4,4,5,3] return 1 and 5
Challenge

O(n) time, O(1) extra space.

 */

//所有数字进行异或，得到的结果用二进制表示为1的位是x,y不同的位。 提取最右不同的位，把数组分成两组，一组and最有位为1，一组为0
public class singleNumber3 {
	/**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> res = new ArrayList<Integer>();
        int xor = 0;
        for (int v : A) {
            xor = xor ^ v;
        }
        //110110-> 110101->001010->000010
        int rightMost1 = xor & ~(xor-1);
        int x = 0;
        int y = 0;
        for (int v : A) {
        	//位操作优先级低于比较操作
            if ((v & rightMost1) == 0)
                x = x ^ v;
            else
                y = y ^ v;
        }
        res.add(x);
        res.add(y);
        return res;
    }
}
