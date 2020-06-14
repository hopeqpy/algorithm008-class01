package 中等;


import java.util.*;
import java.util.LinkedList;

/**
 * @program: algorithm
 * @description: 归并翻转
 * @author: qpy
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        int length = intervals.length;
        Arrays.sort( intervals, Comparator.comparing( a -> a[0] ) );
        List<int[]> result = new ArrayList<int[]>( length );
        int i = 0;
        while (i < length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < length - 1 && intervals[i + 1][0] <=right) {
                right = Math.max( right, intervals[i + 1][1] );
                i++;
            }
            result.add( new int[]{left, right} );
            i++;
        }
        return result.toArray( new int[0][] );
    }
}
