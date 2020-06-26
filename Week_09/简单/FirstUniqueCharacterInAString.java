package 简单;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 第一个唯一字符串
 * @author: qpy
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int[] count = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            count[c - 'a']++;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (count[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
