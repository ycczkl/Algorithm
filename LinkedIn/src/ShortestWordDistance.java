import java.util.*;
/*
 * Please design and implement a class:
This class will be given a list of words (such as might be tokenized from a paragraph of text),
 and will provide a method that takes two words and returns the shortest distance (in words) between those two words in the provided text.
 
 Follow up: 如果list无重复如何优化。 利用hashmap, key为word, value 为index
 
 Follow up: 如果频繁调用这个函数，怎么进行优化？ 用hashmap<String, List<Integer>>, 把问题转换成找出两个有序数组之中两个数的最小差值。
 此时又有两种情况：1.量数组长度差异不大，利用类似merge list的思路进行最小差值的查询，维护一个globalMin的变量, O(m+n)。 2.如果两数组差异很大，
 则把小数组之中的数作为值，在大数组中进行二分查找，取最小值差值。
 
 *
 */
// ShortestWordDistance finder = new ShortestWordDistance(Arrays.asList({"word","hi","fox","ki","word","fox"}));
// finder("fox", "word");
public class ShortestWordDistance {
	List<String> list;
	public ShortestWordDistance(List<String> list) {
		this.list = list;
	}
	
	public int findMinDistance(String s1, String s2) {
		int pos1 = -1;
		int pos2 = -1;
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(s1)) {
				if (pos1 < 0 || pos2 < 0)
					pos1 = i;
				else {
					dis = Math.abs(pos1-pos2);
					if (Math.abs(i - pos2) < dis) {						
						dis = Math.abs(i - pos2);
					}
					pos1 = i;
				}
			} else if (list.get(i).equals(s2)) {
				if (pos1 < 0 || pos2 < 0) {
					pos2 = i;
				} else {
					dis = Math.abs(pos1- pos2);
					if (Math.abs(i- pos1) < dis) {						
						dis = Math.abs(i - pos1);
					}
					pos2 = i;
				}
			}
		}
		return Math.min(dis, Math.abs(pos1-pos2));
	}
	
	//polished
	public int findMinDistance2(String s1, String s2) {
		int pos1 = -1;
		int pos2 = -1;
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(s1)) {
				pos1 = i;
				if (pos2 >= 0) dis = Math.min(dis, i-pos2);				
				
			} else if (list.get(i).equals(s2)) {
				pos2 = i;
				if (pos1 >= 0) dis = Math.min(dis, i-pos1);
			}
		}
		return (pos1 < 0 || pos2 < 0) ? -1 : dis;
	}
	
	public static void main(String[] args) {
		ShortestWordDistance finder = new ShortestWordDistance(Arrays.asList("the", "quick", "brown", "fox", "quick"));
		System.out.println(finder.findMinDistance2("fox", "the"));
		System.out.println(finder.findMinDistance2("quick", "fox"));
	}
}
