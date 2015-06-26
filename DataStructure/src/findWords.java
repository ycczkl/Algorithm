import java.util.*;
class TireNode {
    boolean isEnd;
    HashMap<Character, TireNode> map;
    
    public TireNode() {
        isEnd = false;
        map = new HashMap<Character, TireNode>();
    }
}

class Tire {
    TireNode root = new TireNode();
    
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
    
    public boolean search(String word) {
        TireNode p = root;
        for (char c : word.toCharArray()) {
            if (!p.map.containsKey(c)) return false;
            p = p.map.get(c);
        }
        return p.isEnd;
    }
    
    public boolean isPrefix(String word) {
        TireNode p = root;
        for (char c : word.toCharArray()) {
            if (!p.map.containsKey(c)) return false;
            p = p.map.get(c);
        }
        return !p.isEnd;
    }
}
public class findWords {
public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<String>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) return new ArrayList<String>();
        Tire tire = new Tire();
        for (String word : words) tire.addWord(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i, j, set, tire, new StringBuilder(Character.toString(board[i][j])));
            }
        }
        return new ArrayList<String>(set);
    }
    private void dfs(char board[][], int i, int j, HashSet<String> set, Tire tire, StringBuilder sb) {
        if (!tire.isPrefix(sb.toString()) ) return;
        if (tire.search(sb.toString())) {
            set.add(sb.toString());
        }
        if (i+1 < board.length)
            dfs(board, i+1, j, set, tire,sb.append(board[i+1][j]));
        if (i > 0)
            dfs(board, i-1, j, set, tire,sb.append(board[i-1][j]));
        if (j+1 < board[0].length)
            dfs(board, i, j+1, set, tire,sb.append(board[i][j+1]));
        if (j > 0)
            dfs(board, i, j-1, set, tire,sb.append(board[i][j-1]));
    }
    public static void main(String[] args) {
    	findWords obj = new findWords();
    	obj.findWords({"a"}, {"a"});
    }
}