import java.util.*;
/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */

//O(n*n)复杂度。 先排序，设置一个全局变量closest,用two pointer 两头扫，若小于closest则更新sum和closest 
public class threeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return 0;
        int closest = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length -2; i++) {
            int left = i+1;
            int right = num.length-1;
            while (left < right) {
                if(closest > Math.abs(num[i]+num[left]+num[right]-target)) {
                    sum = num[i]+num[left]+num[right];
                    closest = Math.abs(num[i]+num[left]+num[right]-target);
                }
                if (num[i]+num[left]+num[right] < target)
                    left++;
                else if (num[i]+num[left]+num[right] > target)
                    right--;
                else
                    return target;
            }
        }
        return sum;
    }
}
