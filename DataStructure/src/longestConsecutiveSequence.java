import java.util.*;
/*
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
 */
//根据题意，我们要找的是连续序列，所以不需要考虑重复的情况。此时可以考虑用hashset
public class longestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int item : num) {
			set.add(item);
		}
		int globalLen = 0;
		while (!set.isEmpty()) {
			int len = 0;
			Iterator<Integer> it = set.iterator();
			int item = it.next();
			int copy = item;
			while (set.contains(copy)) {
				len++;
				set.remove(copy++);
			}
			item--;
			while (set.contains(item)) {
				len++;
				set.remove(item--);				
			}
			globalLen = Math.max(globalLen, len);
		}
		return globalLen;
    }
}
