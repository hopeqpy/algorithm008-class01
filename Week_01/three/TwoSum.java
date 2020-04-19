package three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 两数之和
 * @author: qpy
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> indexList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey( target - nums[i] )) {
                indexList.add( i );
                indexList.add( map.get( target - nums[i] ) );
            }
            map.put( nums[i], i );
        }
        if (indexList.size() > 0) {
            return indexList.stream().mapToInt( Integer::intValue ).toArray();
        } else {
            return null;
        }

    }

}
