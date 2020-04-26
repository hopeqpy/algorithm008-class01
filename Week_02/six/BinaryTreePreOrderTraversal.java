package six;

import java.util.*;

/**
 * @program: algorithm
 * @description: 二叉树前序遍历 --采用递归
 */
public class BinaryTreePreOrderTraversal {


    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result =new ArrayList<>(  );
        preOrderTraversal( root,result );
        return result;
    }


    private List<Integer> preOrderTraversal(TreeNode root, List<Integer> list) {

        list.add(root.val);
        if(root.left != null){
            preOrderTraversal( root.left, list );
        }
        if(root.right != null){
            preOrderTraversal(root.right, list);
        }
        return list;
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
