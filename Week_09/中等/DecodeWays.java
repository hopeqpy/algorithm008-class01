package 中等;

/**
 * @program: algorithm
 * @description: 解码方法
 * @author: qpy
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (s.charAt( 0 ) == '0') {
            return 0;
        }
        // dp[i] 成长度为 i 的前缀子串有多少种解码方法
        // if nums[i - 1] != '0'
        // dp[i] = dp[i - 1] * 1
        //if  10 <= int(s) <= 26
        // dp[i] += dp[i - 2] * 1

        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt( length - 1 ) != '0') {
            dp[length - 1] = 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt( i ) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt( i ) - '0') * 10 + (s.charAt( i + 1 ) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
