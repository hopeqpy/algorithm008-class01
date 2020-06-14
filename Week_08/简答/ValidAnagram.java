package 简答;

/**
 * @program: algorithm
 * @description: 有效的字母异位词
 * @author: qpy
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[sCharArray[i] - 'a']++;
            count[tCharArray[i] - 'a']--;
        }
        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
