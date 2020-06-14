package 困难;

/**
 * @program: algorithm
 * @description: n 皇后 II
 * @author: qpy
 */
public class NQueensII {
    int count = 0;

    public int totalNQueens(int n) {

        dfs( 0, 0, 0, 0, n );
        return count;
    }

    public void dfs(int row, int column, int pie, int na, int n) {
        if (row == n) {
            count++;
        }
        for (int i = 0; i < n; i++) {
            int j = row + i, k = i - row + n - 1;
            if (((column >> i) & 1) == 1 || ((pie >> j) & 1) == 1 || ((na >> k) & 1) == 1) {
                continue;
            }
            column ^= (1 << i);
            pie ^= (1 << j);
            na ^= (1 << k);
            dfs( row + 1, column, pie, na, n );
            column ^= (1 << i);
            pie ^= (1 << j);
            na ^= (1 << k);
        }
    }
}
