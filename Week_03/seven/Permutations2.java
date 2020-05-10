package seven;

import java.util.*;

/**
 * @program: algorithm
 * @description: 全排列 II
 * @author: qpy
 */
public class Permutations2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        back(result, temp, nums);
        return result;
    }

    private void back(List<List<Integer>> result, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                back(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
