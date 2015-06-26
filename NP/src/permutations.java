import java.util.*;

/*
 * Given a list of numbers, return all possible permutations.
 Example

 For nums [1,2,3], the permutaions are: 

 [

 [1,2,3],

 [1,3,2],

 [2,1,3],

 [2,3,1],

 [3,1,2],

 [3,2,1]

 ]
 */
public class permutations {
	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: A list of permutations.
	 */
	//时间复杂度(O(N!))
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return res;
		boolean[] used = new boolean[num.length];
		helper(num, used, new ArrayList<Integer>(), res);
		return res;
	}

	private void helper(int[] num, boolean[] used, ArrayList<Integer> list,
			List<List<Integer>> res) {
		if (list.size() == num.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {
				used[i] = true;
				list.add(num[i]);
				helper(num, used, list, res);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
	}
	
	//插空法
	public List<List<Integer>> permute2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return res;
		List<Integer> list = new LinkedList<Integer>();
		list.add(num[0]);
		res.add(list);
		for (int i = 1; i < num.length; i++) {
			int size = res.size();
			List<List<Integer>> newRes = new ArrayList<List<Integer>>();
			for (List<Integer> line : res) {
				int lineSize = line.size();
				for (int j = 0; j <= lineSize; j++) {
					List<Integer> tmp = new LinkedList<Integer>(line);
					tmp.add(j, num[i]);
					newRes.add(tmp);
				}
			}
			res = newRes;
		}
		return res;
	}
}
