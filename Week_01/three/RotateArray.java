package three;


/**
 * @program: algorithm
 * @description: 旋转数组
 * @author: qpy
 */
class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int inFactMove = k % (nums.length);
        int[] newArray = new int[k];
        System.arraycopy( nums, nums.length-inFactMove, newArray, 0, inFactMove );
        System.arraycopy( nums, 0, nums, inFactMove, nums.length-inFactMove );
        System.arraycopy( newArray, 0, nums, 0, k );
    }
}
