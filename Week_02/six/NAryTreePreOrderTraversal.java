package six;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: N叉树的前序遍历 --采用迭代
 * @author: qpy
 */
public class NAryTreePreOrderTraversal {

    public List<Integer> preOrder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push( root );
        while (!stack.isEmpty()) {
            Node remove = stack.pop();
            result.add( remove.val );
            List<Node> nodeList = remove.children;
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                stack.push( nodeList.get( i ) );
            }
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
