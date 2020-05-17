import java.util.*;

/**
 * @program: algorithm
 * @description: 单词接龙 II
 * @author: qpy
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains( endWord )) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer( beginWord );
        visited.add( beginWord );
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String word : wordList) {
                    if (visited.contains( word )) {
                        continue;
                    }
                    if (!change( start, word )) {
                        continue;
                    }
                    if (word.equals( endWord )) {
                        return ++count;
                    }
                    visited.add( word );
                    queue.offer( word );
                }
            }
        }
        return 0;
    }

    public boolean change(String start, String word) {
        if (start.length() != word.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt( i ) != word.charAt( i )) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
