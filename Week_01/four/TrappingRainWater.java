package four;

/**
 * @program: algorithm
 * @description:
 * @author: qpy
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;
        //找出最大值的下标以及位置
        int index = 0;
        int maxVolume = height[0];
        for (int i = 1; i < height.length; i++) {
            if (maxVolume < height[i]) {
                maxVolume = height[i];
                index = i;
            }
        }
        //求出左边的trap
        int sum = 0;
        int leftVolume = height[0];
        for (int i = 1; i < index; i++) {
            if (leftVolume < height[i]) {
                leftVolume = height[i];
            } else {
                sum += (leftVolume - height[i]);
            }
        }
        //右边的trap
        int rightVolume = height[height.length - 1];
        for (int i = height.length - 2; i > index; i--) {
            if (rightVolume < height[i]) {
                rightVolume = height[i];
            } else {
                sum += (rightVolume - height[i]);
            }
        }

        return sum;
    }
}
