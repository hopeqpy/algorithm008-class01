package seven;

import java.util.*;

/**
 * @program: algorithm
 * @description: 全排列
 * @author: qpy
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length == 0){
            return result;
        }
        LinkedList<Integer> temp = new LinkedList<>();
        back(result,nums, temp );
        return result;
    }
    public void back(List<List<Integer>>result ,int[] nums, LinkedList<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new LinkedList<>( temp ));
            return ;
        }
        for(int i = 0; i<nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            back(result,nums,temp);
            temp.removeLast();
        }
    }
}
