package six;

import java.util.*;

/**
 * @program: algorithm
 * @description: N叉树的层序遍历  --采用队列
 * @author: qpy
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add( root );
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node remove = queue.poll();
                list.add( remove.val );
                for (Node node : remove.children) {
                    if (node != null) {
                        queue.add( node );
                    }
                }
            }
            result.add( list );
        }
        return result;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
