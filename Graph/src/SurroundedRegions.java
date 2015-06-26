import java.util.*;

public class SurroundedRegions {
	// flood fill 算法 O(m*n)复杂度
	public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                bfs(board, 0, i);
            if (board[board.length-1][i] == 'O')
                bfs(board, board.length-1, i);
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
            if (board[i][board[0].length-1] == 'O')
                bfs(board, i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'O')
                    board[j][i] = 'X';
                if (board[j][i] == '#')
                    board[j][i] = 'O';
            }
        }
        return;
    }
    private static void bfs(char[][] board, int i, int j) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i*board[0].length+j);
        board[i][j] = '#';
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int row = code/board[0].length;
            int col = code%board[0].length;                        
            if (row != 0 && board[row-1][col] == 'O') {
                queue.offer((row-1)*board[0].length+col);
                board[row-1][col] = '#';
            }
            if (row != board.length-1 && board[row+1][col] == 'O') {
                queue.offer((row+1)*board[0].length+col);
                board[row+1][col] = '#';
            }
            if (col != 0 && board[row][col-1] == 'O') {
                queue.offer(row*board[0].length+col-1);
                board[row][col-1] = '#';
            }
            if (col != board[0].length-1 && board[row][col+1] == 'O') {
                queue.offer(row*board[0].length+col+1);
                board[row][col+1] = '#';
            }
        }
    }
    
    public static void main(String[] args) {
    	char[][] a = new char[2][2];
    	a[0][0] = 'O';
    	a[0][1] = 'O';
    	a[1][1] = 'O';
    	a[1][0] = 'O';
    	solve(a);
    	System.out.println(5&6%7);
    }
}
