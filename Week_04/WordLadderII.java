
import java.util.*;

/**
 * @program: algorithm
 * @description: 单词接龙 II
 * @author: qpy
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList();
        Set<String> dict = new HashSet<>( wordList );
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>( Arrays.asList( beginWord ) );
        queue.add( list );
        visited.add( beginWord );
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();

                String word = path.get( path.size() - 1 );
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String( chars );

                        if (dict.contains( str ) && !visited.contains( str )) {
                            List<String> pathList = new ArrayList<>( path );
                            pathList.add( str );
                            if (str.equals( endWord )) {
                                flag = true;
                                result.add( pathList );
                            }
                            queue.add( pathList );
                            subVisited.add( str );
                        }
                    }
                    chars[j] = temp;
                }
            }
            visited.addAll( subVisited );
        }
        return result;
    }
}
