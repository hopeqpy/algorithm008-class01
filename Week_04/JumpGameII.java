/**
 * @program: algorithm
 * @description: 跳跃游戏II
 * @author: qpy
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int end = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max( max, i + nums[i] );
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
