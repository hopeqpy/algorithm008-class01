package seven;

import java.util.*;

/**
 * @program: algorithm
 * @description: 组合
 * @author: qpy
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }
        LinkedList<Integer> temp = new LinkedList<>();
        findCombination( result, n, k, 1, temp );

        return result;
    }


    private void findCombination(LinkedList<List<Integer>> result,
                                 int n, int k, int start, LinkedList<Integer> temp) {

        if (temp.size() == k) {
            result.addLast( (List<Integer>) temp.clone() );
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.addLast( i );
            findCombination( result, n, k, i + 1, temp );
            temp.removeLast();
        }
        return;
    }
}
