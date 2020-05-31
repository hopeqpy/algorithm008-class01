/**
 * @program: algorithm
 * @description:
 * @author: qpy
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, column = matrix[0].length;
        int res = 0;
        int[] dp = new int[column + 1];
        for (int i = 0; i < row; i++) {
            int pre = 0;
            for (int j = 1; j <= column; j++) {
                if (matrix[i][j - 1] == '0') {
                    pre = dp[j];
                    dp[j] = 0;
                } else {
                    int tmp = dp[j];
                    dp[j] = 1 + Math.min(pre, Math.min(dp[j - 1], dp[j]));
                    if (dp[j] > res){
                        res = dp[j];
                    }
                    pre = tmp;
                }
            }
        }
        return res * res;
    }


}
