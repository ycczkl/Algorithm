import java.util.*;

/*
 *Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

 Find it.
 Note

 There is only one majority number in the array.
 Example

 Given [1, 2, 1, 2, 1, 3, 3], return 1.
 Challenge

 O(n) time and O(1) extra space.

 */

public class majorityElement2 {
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: The majority number that occurs more than 1/3
	 */
		
	//Use two counter to count.
	public int majorityNumber(ArrayList<Integer> nums) {
		int major1 = 0;
		int major2 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int v : nums) {

			if (v == major1) {
				count1++;
			}
			if (v == major2) {
				count2++;
			}
			if (v != major1 && v != major2) {
				if (count1 == 0) {
					major1 = v;
					count1++;
					continue;
				}
				if (count2 == 0) {
					major2 = v;
					count2++;
					continue;
				}
				if (count1 != 0 && count2 != 0) {
					count1--;
					count2--;
				}

			}

		}
		count1 = 0;
		count2 = 0;
		for (int v : nums) {
			if (v == major1)
				count1++;
			if (v == major2)
				count2++;
		}
		return count1 > count2 ? major1 : major2;
	}
}
