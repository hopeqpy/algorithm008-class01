package 中等;

/**
 * @program: algorithm
 * @description: 岛屿的数量
 * @author: qpy
 */
public class NumberIslands {
    //表示四联通的方向
    private static final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    //标记
    private boolean[][] marked;
    //行
    private int rows;
    //列
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + dirs[k][0];
            int newY = j + dirs[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
