package 困难;

import java.util.*;
import java.util.Collections;

/**
 *
 * 树状数组解释 ：http://www.cppblog.com/menjitianya/archive/2015/11/02/212171.html
 * @program: algorithm
 * @description: 翻转对
 * @author: qpy
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int length = nums.length;
        int[] BIT = new int[length + 1];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            list.add( nums[i] );
        Collections.sort( list );
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += query( BIT, length, lowBound( list, (long) 2 * nums[i] + 1 ) + 1 );
            update( BIT, lowBound( list, (long) nums[i] ) + 1, 1 );
        }
        return result;
    }

    /**
     * 更新操作
     *
     * @param index
     * @param val
     */
    private void update(int[] BIT, int index, int val) {
        while (index > 0) {
            BIT[index] += val;
            index -= index & (-index);
        }
    }

    private int query(int[] BIT, int n, int index) {
        int sum = 0;
        while (index <= n) {
            sum += BIT[index];
            index += index & (-index);
        }
        return sum;
    }

    private int lowBound(List<Integer> list, long x) {
        int left = 0;
        int right = list.size() - 1;
        int privot = left + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get( mid ) >= x) {
                privot = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }

        }
        return privot;
    }

}
