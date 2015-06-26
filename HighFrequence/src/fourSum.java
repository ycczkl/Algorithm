import java.util.*;
public class fourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4)
			return res;		
		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;
				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					if (num[i] + num[j] + num[left] + num[right] == target) {
						if (left != j + 1 && num[left] == num[left - 1]) {
							left++;
						} else {
							List<Integer> list = new ArrayList<Integer>();
							list.add(num[i]);
							list.add(num[j]);
							list.add(num[left]);
							list.add(num[right]);
							res.add(list);
							left++;
						}
					} else if (num[i] + num[j] + num[left] + num[right] < target) {
						left++;
					} else {
						right--;
					}
				}
			}

		}
		return res;
	}
}
