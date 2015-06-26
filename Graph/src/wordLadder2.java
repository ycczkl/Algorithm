import java.util.*;
/*
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

    All words have the same length.
    All words contain only lowercase alphabetic characters.
 */
public class wordLadder2 {
	 //先bfs找最短路径,然后dfs剪枝
	 public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
			List<List<String>> res= new ArrayList<List<String>>();
			int shortest = ladderLength(start, end, dict);			
			if (dict.contains(start))
			    dict.remove(start);
			LinkedList<String> item = new LinkedList<String>();
			item.add(start);
			dfs(shortest, 1, item,end, start, res,dict);
			return res;
	    }
	    private static void dfs(int shortest, int length, List<String> item, String end, String start, List<List<String>> res, Set<String> dict) {
	        if (length > shortest)
	            return;
	        if (start.equals(end)) {	        	
	            res.add(new ArrayList<String>(item));
	            return;
	        }	        
	        LinkedList<String> neighbors = getNeighbors(start, dict);	        
	        for (String s: neighbors) {
	            dict.remove(s);
	            item.add(s);	            
	            dfs(shortest, length+1, item, end, s, res, dict);
	            item.remove(item.size()-1);
	            dict.add(s);
	        }
	    }
		private static LinkedList<String> getNeighbors(String str, Set<String> dict) {
			LinkedList<String> neighbors = new LinkedList<String>();
			for (int i = 0; i < str.length(); i++) {
				for (int j = 'a'; j <= 'z'; j++) {	
					StringBuilder sb = new StringBuilder(str);
					sb.setCharAt(i, (char)j);
					if (!str.equals(sb.toString()) && dict.contains(sb.toString())) {
						neighbors.add(sb.toString());
					}
				}
			}			
			return neighbors;
		}
		public static int ladderLength(String start, String end, Set<String> set) {
			HashSet<String> dict = new HashSet<String>(set);
		   if (start == null || end == null || dict == null)
			   return 0;
		   int depth = 1;
		   Queue<String> queue = new LinkedList<String>();
		   queue.offer(start);
		   if (dict.contains(start))
			   dict.remove(start);
		   while (!queue.isEmpty()) {
			   int size = queue.size();
			   for (int i = 0; i < size; i++) {
				   String cur = queue.poll();
				   for (int j = 0; j < cur.length(); j++) {
					   for (int k = 'a'; k <= 'z'; k++) {
						   String tmp = replace(cur, j, (char)k);
						   if (tmp.equals(end))
							   return depth+1;
						   if (dict.contains(tmp)) {
							   queue.offer(tmp);
							   dict.remove(tmp);
						   }
					   }
				   }
			   }
			   depth++;
		   }
		   return 0;
	   }
	   private static String replace(String str, int j, char k) {
		   StringBuilder sb = new StringBuilder(str);
		   sb.setCharAt(j, k);
		   return sb.toString();
	   }
	   public static void main(String[] args) {
		   String[] arr = {"hot","cog","dog","tot","hog","hop","pot","dot"};
		   HashSet<String> set = new HashSet<String>(Arrays.asList(arr));		   
		   findLadders("hot", "dog", set);
	   }
	
	//先bfs，保存每个节点的前驱节点。 找到end后进行bfs回溯。 空间换时间的方法。在进行bfs过程中，找到end那一层时，所有最短路径已经都遍历过了。	   
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res= new ArrayList<List<String>>();
		HashMap<String, Integer> minPathMap = new HashMap<String, Integer>();
		HashMap<String, LinkedList<String>> preNodeMap = new HashMap<String, LinkedList<String>>();
		dict.add(start);
		dict.add(end);
		bfs(start, end, minPathMap, preNodeMap, dict);
		dfs(new LinkedList<String>(),end, start, minPathMap, preNodeMap, res, dict);
		return res;
    }
	private void bfs(String start, String end, HashMap<String, Integer> minPathMap, HashMap<String, LinkedList<String>> preNodeMap, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		minPathMap.put(start, 0);		
		queue.add(start);
		for (String node : dict) {
			preNodeMap.put(node, new LinkedList<String>());
		}
		boolean cut = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				List<String> neighbors = getNeighbors(str, dict);
				for (String neighbor : neighbors) {
					if (neighbor.equals(end))
						cut = true;
					if (!minPathMap.containsKey(neighbor)) {
						minPathMap.put(neighbor, minPathMap.get(str)+1);
						queue.offer(neighbor);
					}
					preNodeMap.get(neighbor).add(str);
				}	
			}
			if (cut)
				break;
		}
	}
	
	private LinkedList<String> getNeighbors(String str, Set<String> dict) {
		LinkedList<String> neighbors = new LinkedList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 'a'; j < 'z'; j++) {
				StringBuilder sb = new StringBuilder(str);
				sb.setCharAt(i, (char)j);
				if (!str.equals(sb.toString()) && dict.contains(sb.toString())) {
					neighbors.add(sb.toString());
				}
			}
		}
		return neighbors;
	}
	public void dfs(List<String> item, String end, String start, HashMap<String, Integer> minPathMap, HashMap<String, LinkedList<String>> preNodeMap, List<List<String>> res, Set<String> dict) {
		item.add(end);
		if (end.equals(start)) {			
			Collections.reverse(item);
			res.add(new ArrayList<String>(item));
			Collections.reverse(item);
			return;
		}
		LinkedList<String> preNodeList = preNodeMap.get(end);
		for (String pre : preNodeList) {
			if (minPathMap.get(pre) == minPathMap.get(end)-1) {
				dfs(item, pre, start, minPathMap, preNodeMap, res, dict);
				item.remove(item.size()-1);
			}
		}
	}
}
