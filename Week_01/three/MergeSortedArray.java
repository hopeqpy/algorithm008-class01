package three;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 合并两个有序数组
 * @author: qpy
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        System.arraycopy( nums2,0,nums1,m,n );
        Arrays.sort(nums1);
    }

}
