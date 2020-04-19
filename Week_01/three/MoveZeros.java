package three;

/**
 * @program: algorithm
 * @description: 移动零
 * @author: qpy
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int nextZeroPosition = 1;
        boolean skip = false;
        for (int i = 0; i < length; i = skip ? nextZeroPosition : i + 1) {
            int a = nums[i];
            boolean repeatZero = false;
            if (a == 0) {
                int temp = i;
                for (int j = i + 1; j < length; j = j + 1) {
                    if (nums[j] != 0) {
                        nums[temp] = nums[j];
                        temp = j;
                        nums[j] = 0;
                    } else {
                        if (!repeatZero) {
                            repeatZero = true;
                            nextZeroPosition = j;
                            skip = true;
                        }
                    }
                }
                if (!repeatZero) {
                    skip = false;
                }
            } else {
                continue;
            }
        }
    }
}
