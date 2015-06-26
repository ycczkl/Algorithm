import java.util.*;
/*
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.
Note

There is only one majority number in the array.
Example

Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
Challenge

O(n) time and O(k) extra space

 */
public class majorityElements3 {
	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
	public static int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums.size() < k)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int v : nums) {
            if (map.containsKey(v)) {
                map.put(v, map.get(v)+1);
            } else {
                if (map.size() < k)
                    map.put(v, 1);
                else {
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    for (int e : map.keySet()) {
                        int count = map.get(e);
                        --count;
                        if (count > 0) {
                            tmp.put(e, count);
                        } else if (count == 0){
                            tmp.put(v, 0);
                        }
                    }
                    map = tmp;
                }
            }
        }
        int count = 0;
        int res = 0;
        for (int e : map.keySet()) {
            if (map.get(e) > count) {
                count = map.get(e);
                res = e;
            }
        }
        return res;
    }
	public static void main (String[] args) {
		int[] arr = {3,1,2,3,2,3,3,4,4,4};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr) {
			list.add(i);
		}
		System.out.println(majorityNumber(list ,3));
	}
}
