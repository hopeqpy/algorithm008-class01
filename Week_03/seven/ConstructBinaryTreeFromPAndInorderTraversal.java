package seven;

/**
 * @program: algorithm
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: qpy
 */
public class ConstructBinaryTreeFromPAndInorderTraversal {

    public TreeNode buildTree(int[] p, int[] inorder) {
        return help( 0, 0, inorder.length - 1, p, inorder );
    }

    private TreeNode help(int preStart, int inStart, int inEnd, int[] p, int[] inorder) {
        if (preStart > p.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode( p[preStart] );
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }
        root.left = help( preStart + 1, inStart, rootIndex - 1, p, inorder );
        root.right = help( preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, p, inorder );
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
