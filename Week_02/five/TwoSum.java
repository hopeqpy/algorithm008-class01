package five;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 两书之和  跟之前一样  进行一部分优化
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.get( other ) != null) {
                result[0] = map.get( other );
                result[1] = i;
                return result;
            }
            map.put( nums[i], i );
        }
        return result;
    }

}
