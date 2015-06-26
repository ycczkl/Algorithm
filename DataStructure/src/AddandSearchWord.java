import java.util.*;

class TireNode {
	boolean isEnd;
	HashMap<Character, TireNode> map;

	public TireNode() {
		isEnd = false;
		map = new HashMap<Character, TireNode>();
	}
}

public class AddandSearchWord {
	TireNode root = new TireNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		TireNode p = root;
		for (char c : word.toCharArray()) {
			if (!p.map.containsKey(c)) {
				p.map.put(c, new TireNode());
			}
			p = p.map.get(c);
		}
		p.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return helper(word.toCharArray(), root, 0);
	}

	private boolean helper(char[] arr, TireNode p, int index) {
		System.out.println(index);
		if (index == arr.length)
			return p.isEnd;

		char c = arr[index];
//		System.out.println(c);
		if (c == '.') {
			Set<Character> keys = p.map.keySet();
			if (keys.size() == 0)
				return false;
			index++;
			for (char key : keys) {
				System.out.println(key);				
				if (helper(arr, p.map.get(key), index)) return true;					
			}
		} else {
			if (p.map.containsKey(c)) {
				System.out.println(c);
				p = p.map.get(c);
				return (helper(arr, p, ++index));					
			} else {
				return false;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		AddandSearchWord obj = new AddandSearchWord();
		obj.addWord("at");
		obj.addWord("and");
		obj.addWord("an");
		obj.addWord("add");		
//		System.out.println(obj.search("a"));
//		System.out.println(obj.search(".at"));
		obj.addWord("bat");
//		System.out.println(obj.search(".at"));
//		System.out.println(obj.search("an."));
		System.out.println(obj.search("a.d."));
//		System.out.println(obj.search("b."));
//		System.out.println(obj.search("a.d"));
	}
}
