import java.util.*;
/*
 *  Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

Note

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

Example

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class wordLadder {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
	//BFS,思路与clone graph相同
   public int ladderLength(String start, String end, Set<String> dict) {
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
   private String replace(String str, int j, char k) {
	   StringBuilder sb = new StringBuilder(str);
	   sb.setCharAt(j, k);
	   return sb.toString();
   }
}
