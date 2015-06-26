/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
Example

Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class wordSearch {
	/**
	 * @param board
	 *            : A list of lists of character
	 * @param word
	 *            : A string
	 * @return: A boolean
	 */
	// DFS. 时间复杂度O(m*m*n*n) 空间复杂度O(m*n),记住要用数组记录是否访问过
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (dfs(board, i, j, word,
						new boolean[board.length][board[0].length]))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int j, int i, String word,
			boolean[][] used) {
		boolean res = false;
		if (word.isEmpty())
			return true;
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
				|| used[i][j] == true || board[i][j] != word.charAt(0))
			return false;
		else {
			word = word.substring(1);
			used[i][j] = true;
			res = dfs(board, j + 1, i, word, used)
					|| dfs(board, j - 1, i, word, used)
					|| dfs(board, j, i + 1, word, used)
					|| dfs(board, j, i - 1, word, used);
			used[i][j] = false;
		}
		return res;
	}
}
