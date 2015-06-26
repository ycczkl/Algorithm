import java.util.*;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
 */
public class twoSum {
	// 考虑特殊情况，例如0,1,2,0 | 0. 考虑答案是否唯一，数组是否有重。 有重复情况下小心使用hashmap
	// O(n)时间复杂度
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		if (numbers == null || numbers.length < 2)
			return res;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			int value = target - numbers[i];
			if (map.containsKey(value)) {
				res[0] = map.get(value);
				res[1] = i + 1;
				break;
			}
			map.put(numbers[i], i + 1);
		}
		return res;
	}
	
	//变形1：返回值而非index, Can use Two pointer， O(nlgn)时间复杂度
	public int[] twoSum2(int[] numbers, int target) {
		int[] res = new int[2];
		if (numbers == null || numbers.length < 2)
			return res;
		Arrays.sort(numbers);
		int pointer1 = 0;
		int pointer2 = numbers.length-1;
		while (pointer1 != pointer2) {
			if (numbers[pointer1] + numbers[pointer2] == 0) {
				res[0] = numbers[pointer1];
				res[1] = numbers[pointer2];
				break;
			} else if (numbers[pointer1] + numbers[pointer2] > 0) {
				pointer2--;
			} else {
				pointer1++;
			}
		}
		return res;
	}
	
	//变形2；找出所有可能的pair，不能有重复. O(nlgn)
	public List<List<Integer>> twoSum3(int[] numbers, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numbers == null || numbers.length < 2)
			return res;
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length-1;		
		while (left < right) {
			if (left != 0 && numbers[left] == numbers[left]-1)
				left++;
			else {
				if (numbers[left] + numbers[right] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(numbers[left]);
					list.add(numbers[right]);
					res.add(list);
				} else if (numbers[left] + numbers[right] < target)
					left++;
				else
					right--;					
			}
		}
		return res;
	}
	//变形3： 运用hashset去重
	public List<List<Integer>> twoSum4(int[] numbers, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numbers == null || numbers.length < 2)
			return res;
		Arrays.sort(numbers);
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<List<Integer>> checkList = new HashSet<List<Integer>>();
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (set.contains(target - numbers[j])) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(target-numbers[j]);
					list.add(numbers[j]);
					if (!checkList.contains(list)) {
						res.add(list);
						checkList.add(list);
					}
				}
			}
			set.add(numbers[i]);
		}
		return res;
	}
}
