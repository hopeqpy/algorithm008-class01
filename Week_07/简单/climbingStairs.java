package 简单;

/**
 * @program: algorithm
 * @description: 爬梯子  -采用dp
 * @author: qpy
 */
public class climbingStairs {

    public int climbingStairs(int n){
        int [] dp =new int[n];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
