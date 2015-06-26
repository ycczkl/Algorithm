import java.util.*;
/*
 * Given an array of strings, return all groups of strings that are anagrams.
Example

Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
Note

All inputs will be in lower-case
 */

//Brute force方法，对每个字符串进行检测，用used数组记录字符串是否已经检测过。O(k*n^2)，空间O(n)
public class Anagrams {
	public List<String> anagrams(String[] strs) {
        boolean[] used = new boolean[strs.length];
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue;
            for (int j = i+1; j < strs.length; j++) {
                if (!used[j] && isAnagrams(strs[i], strs[j])) {
                    if (!used[i])
                        res.add(strs[i]);
                    res.add(strs[j]);
                    used[i] = true;
                    used[j] = true;
                }
            }
        }
        return res; 
    }
    
    private boolean isAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c))
                return false;
            map.put(c, map.get(c)-1);
            if (map.get(c) < 0)
                return false;
        }
        return true;
    }
    
    //法2：先计算每个字符串中字符出现次数，按照字符大小顺序进行hash值计算。 把对应哈希值加入到map中。 最后遍历map取得结果。
    private int getHash(String s) {
    	int[] count = new int[26];
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		count[c-'a']++;
    	}
    	int hash = 0;
    	int base = 29;    	
    	for (int i : count) {
    		hash = hash * base + i;
    	}
    	return hash;
    }
    public List<String> anagrams2(String[] strs) {
    	List<String> res = new ArrayList<String>();
    	HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
    	for (String s : strs) {
    		int hash = getHash(s);
    		if (!map.containsKey(hash)) {
    			ArrayList<String> item = new ArrayList<String>();
    			item.add(s);
    			map.put(hash, item);
    		} else 
    			map.get(hash).add(s);
    	}
    	for (ArrayList<String> list : map.values()) {
    		if (list.size()>1)
    			res.addAll(list);
    	}
    	return res;
    }    
}
