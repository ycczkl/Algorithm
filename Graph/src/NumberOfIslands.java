import java.util.*;
/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                bfs(grid, i, j, item);
            }
        }
        return item.get(0);
    }
    private void bfs(char[][] grid, int i, int j, ArrayList<Integer> item) {
        if (grid[i][j] != '1')
            return;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i*grid[0].length+j);
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int row = code/grid[0].length;
            int col = code%grid[0].length;
            if (row != 0 && grid[row-1][col] == '1') {
                queue.offer((row-1)*grid[0].length+col);
                grid[row-1][col] = '0';
            }
            if (row != grid.length-1 && grid[row+1][col] == '1') {
                queue.offer((row+1)*grid[0].length+col);
                grid[row+1][col] = '0';
            }
            if (col != 0 && grid[row][col-1] == '1') {
                queue.offer(row*grid[0].length+col-1);
                grid[row][col-1] = '0';
            }
            if (col != grid[0].length-1 && grid[row][col+1] == '1') {
                queue.offer(row*grid[0].length+col+1);    
                grid[row][col+1] = '0';
            }
        }
        item.set(0, item.get(0)+1);
    }
}
