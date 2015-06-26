import java.util.*;
/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 */

public class threeSum {
	//去重：外层循环，若num[i] - mun[i-1]则continue。 内层循环若num[middle] == middle[middle-1] && middle != i+1, 则middle++
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3)
        	return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
        	if (i != 0 && num[i] == num[i-1])
        		continue;
        	int middle = i+1;
        	int right = num.length-1;
        	while (middle < right) {
        		if (num[i] + num[middle] + num[right] == 0) {
        			if (num[middle] == num[middle-1] && (middle != i+1)) {
        				System.out.println("here");
        				middle++;
        			}
        			else {
        				System.out.println("middle"+middle+"i"+i);
        			    List<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[middle]);
        				list.add(num[right]);
        				res.add(list);
        				middle++;
        			}
        				
        		} else if (num[i] + num[middle] + num[right] < 0) {
        			middle++;
        		} else {
        			right--;
        		}
        	}
        }
        return res;
    }
	
	//把sum2看做sub problem 时间复杂度为O(n*n)
	public List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3)
        	return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
        	if (i != 0 && num[i] == num[i-1]) continue;
        	List<List<Integer>> list = twoSum(num, i+1, -num[i]);
        	for (List<Integer> item: list) {
        		item.add(0, num[i]);
        	}
        	res.addAll(list);
        }
        return res;
	}
	private List<List<Integer>> twoSum(int[] num, int pos, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int left = pos;
		int right = num.length-1;
		while (left < right) {
			if (left != pos && num[left] == num[left-1]) {
				left++;				
			} else {
				if (num[left]+num[right] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[left]);
					list.add(num[right]);
					res.add(list);
					left++;
				} else if (num[left]+num[right] < target)
				    left++;
				else
				    right--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] a = {-1,0,0,1};
		threeSum(a);
	}
}
