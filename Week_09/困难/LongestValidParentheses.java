package 困难;

import java.util.Stack;

/**
 * @program: algorithm
 * @description: 最长有效括号
 * @author: qpy  dp需要参考官方题解
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s){
        if(s==null || s.length()==0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
