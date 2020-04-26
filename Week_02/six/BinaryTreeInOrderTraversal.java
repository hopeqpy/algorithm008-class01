package six;

import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: 二叉树中序遍历  ---采用栈
 */
public class BinaryTreeInOrderTraversal {


    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push( temp );
                temp = temp.left;
            }
            temp = stack.pop();
            result.add( temp.val );
            temp = temp.right;
        }
        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
