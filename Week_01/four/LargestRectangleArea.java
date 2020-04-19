package four;

import java.util.Stack;

/**
 * @program: algorithm  --参考视频课
 * @description: 最大面积
 * @author: qpy
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push( -1 );
        int[] temp = new int[heights.length + 1];
        System.arraycopy( heights, 0, temp, 0, heights.length );
        for (int i = 0; i < temp.length; i++) {
            while (stack.peek() != -1 && temp[stack.peek()] > temp[i]) {
                int top = stack.pop();
                max = Math.max( max, (i - stack.peek() - 1) * temp[top] );
            }
            stack.push( i );
        }
        return max;
    }
}
