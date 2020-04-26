package six;

import javafx.util.Pair;

import java.util.*;

/**
 * @program: algorithm
 * @description: top k 问题  采用优先级队列
 * @author: qpy
 */
public class TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put( i, map.get( i ) == null ? 0 : map.get( i ) + 1 );
        }
        PriorityQueue<Pair<Integer, Integer>> pairs = new PriorityQueue<>( new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        } );
        for (int key : map.keySet()) {
            pairs.add( new Pair<>( key, map.get( key ) ) );
            if (pairs.size() > k)
                pairs.remove();
        }
        List<Integer> result = new ArrayList<>();
        while (!pairs.isEmpty()) {
            result.add( 0, pairs.remove().getKey() );
        }
        return result.stream().mapToInt( Integer::intValue ).toArray();
    }
}