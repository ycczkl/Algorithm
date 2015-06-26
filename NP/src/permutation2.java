import java.util.*;
/*
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
 */

public class permutation2 {
	//插空法，需要hash set查重.
	public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)
        	return null;
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        l.add(num[0]);
        res.add(l);
        set.add(l);
        for (int i = 1; i < num.length; i++) {
        	List<List<Integer>> newRes = new ArrayList<List<Integer>>();
        	for (List<Integer> list : res) {
        		for (int j = 0; j <= list.size(); j++) {
        			if (j < list.size() && list.get(j) == num[i]) {
        				continue;
        			}
        			List<Integer> tmp = new ArrayList<Integer>(list);
        			tmp.add(j, num[i]);
        			if (!set.contains(tmp)) {
        				newRes.add(tmp);
        				set.add(tmp);
        			}
        		}
        	}
        	res = newRes;
        }
        return res;
    }
	
	//递归法
	public List<List<Integer>> permuteUnique2(int[] num) {
        if (num == null || num.length == 0)
        	return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        helper(num, new ArrayList<Integer>(), res, new boolean[num.length]);
        return res;
    }
    private void helper(int[] num, List<Integer> item, List<List<Integer>> res, boolean[] used) {
        if (item.size() == num.length)
            res.add(new ArrayList<Integer>(item));
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && !used[i-1] && num[i] == num[i-1]) continue;
            if (!used[i]) {
                used[i] = true;
                item.add(num[i]);
                helper(num, item, res, used);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }
}
