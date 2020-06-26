package 困难;

/**
 * @program: algorithm
 * @description: 赛车
 * @author: qpy  国际站方式
 */
public class RaceCar {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int k = 1, j = 1;
            for (; j < i; j = (1 << ++k) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], k + 1 + q + 1 + dp[i - (j - p)]);
                }
            }
            dp[i] = Math.min(dp[i], k + (i == j ? 0 : 1 + dp[j - i]));
        }
        return dp[target];
    }
}
