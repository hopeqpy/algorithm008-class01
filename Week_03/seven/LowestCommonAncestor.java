package seven;

/**
 * @program: algorithm
 * @description: 二叉树的最近公共祖先
 * @author: qpy
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCommonAncestor = lowestCommonAncestor( root.left, p, q );
        TreeNode rightCommonAncestor = lowestCommonAncestor( root.right, p, q );
        if (leftCommonAncestor == null) {
            return rightCommonAncestor;
        }
        if (rightCommonAncestor == null) {
            return leftCommonAncestor;
        }
        return root;
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
