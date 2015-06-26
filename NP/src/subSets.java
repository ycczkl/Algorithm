import java.util.*;

/*
 * Given a set of distinct integers, return all possible subsets.
Note

Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
Example

If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class subSets {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	public List<List<Integer>> subsets(int[] S) {
		if (S == null || S.length == 0)
			return null;
		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(S, 0, new ArrayList<Integer>(), res);
		return res;
    }
	private void helper(int[] S, int pos, ArrayList<Integer> item, List<List<Integer>> res) {
		res.add(new ArrayList(item));
		for (int i = pos; i < S.length; i++) {
			item.add(S[i]);
			helper(S, i+1, item, res);
			item.remove(item.size()-1);
		}
	}
	
	//non recrusion
	public List<List<Integer>> subsets2(int[] S) {
		if (S == null || S.length == 0)
			return null;
		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		res.add(item);
		for (int i = 0; i < S.length; i++) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				item = new ArrayList<Integer>(res.get(j));
				item.add(S[i]);
				res.add(item);
			}
		}
		return res;
	}
}
