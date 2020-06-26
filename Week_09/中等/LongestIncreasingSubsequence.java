package 中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: algorithm
 * @description: 最长上升子序列
 * @author: qpy
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = Arrays.binarySearch( dp, 0, res, nums[i] );
            if (idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = nums[i];
            if (idx == res) {
                res++;
            }
        }
        return res;
    }
}
