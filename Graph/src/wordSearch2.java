/*
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 


Example

Given matrix:

doaf
agai
dcan

and dictionary:

{"dog", "dad", "dgdg", "can", "again"}


return {"dog", "dad", "can", "again"}
 */
import java.util.*;

public class wordSearch2 {
	/**
	 * @param board
	 *            : A list of lists of character
	 * @param words
	 *            : A list of string
	 * @return: A list of string
	 */
	public ArrayList<String> wordSearchII(char[][] board,
			ArrayList<String> words) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return null;
		HashMap<String, Boolean> dict = new HashMap<String, Boolean>();
		for (String s : words)
			dict.put(s, true);
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, new StringBuilder(), dict,
						new boolean[board.length][board[0].length], res);
			}
		}
		return res;
	}

	private void dfs(char[][] board, int i, int j, StringBuilder sb,
			HashMap<String, Boolean> dict, boolean[][] used,
			ArrayList<String> res) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
				|| used[i][j] || dict.isEmpty())
			return;
		sb.append(board[i][j]);
		if (dict.containsKey(sb.toString())) {
			res.add(sb.toString());
			dict.remove(sb.toString());
		}
		used[i][j] = true;
		dfs(board, i + 1, j, sb, dict, used, res);
		dfs(board, i - 1, j, sb, dict, used, res);
		dfs(board, i, j + 1, sb, dict, used, res);
		dfs(board, i, j - 1, sb, dict, used, res);
		sb.deleteCharAt(sb.length()-1);
		used[i][j] = false;
	}
}
