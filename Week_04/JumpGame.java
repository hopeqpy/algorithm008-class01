/**
 * @program: algorithm
 * @description: 跳跃游戏
 * @author: qpy
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int temp = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= temp) {
                temp = i;
            }

        }
        return temp == 0;

    }
}
