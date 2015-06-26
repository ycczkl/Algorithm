import java.util.Arrays;
/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 */
public class jumpGame2 {
	public int jump(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        int step = 0;
        int preRange = 0;
        int range = preRange;
        for (int i = 0; i < A.length && i <= range; i++) {
            if (i > preRange) {
                step++;
                preRange = range;
            } 
            range = Math.max(range, i+A[i]);
        }
        return range >= A.length-1 ? step : 0;
    }
}
