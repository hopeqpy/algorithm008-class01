package 简答;

import java.util.*;

/**
 * @program: algorithm
 * @description: 数组的相对排序
 * @author: qpy
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int a2 : arr2) {
            set.add( a2 );
        }

        for (int a1 : arr1) {
            if (set.contains( a1 )) {
                int count = map.containsKey( a1 ) ? map.get( a1 ) + 1 : 1;
                map.put( a1, count );
            } else {
                queue.add( a1 );
            }
        }
        int a11 = 0;
        for (int a22 : arr2) {
            for (int k = 0; k < map.get( a22 ); k++) {
                arr1[a11++] = a22;
            }
        }

        while (!queue.isEmpty()) {
            arr1[a11++] = queue.poll();
        }
        return arr1;
    }

}
