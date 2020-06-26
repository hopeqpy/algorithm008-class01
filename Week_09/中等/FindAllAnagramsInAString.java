package 中等;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 找到字符串中所有字母异位词
 * @author: qpy
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        int slength = s.length();
        int plength = p.length();

        int[] array = new int[26];
        for (char c : p.toCharArray()) {
            array[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < slength; ++i) {
            if (i >= plength) {
                count[charArray[i - plength] - 'a']--;
            }
            count[charArray[i] - 'a']++;

            if (i >= plength - 1) {
                int k = 0;
                while (k < 26) {
                    if (array[k] != count[k]) {
                        break;
                    }
                    k++;
                }
                if (k == 26) {
                    result.add( i - plength + 1 );
                }
            }
        }
        return result;
    }
}
