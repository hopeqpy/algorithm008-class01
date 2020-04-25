package five;

/**
 * @program: algorithm
 * @description: 有效的字母异位词
 */
public class ValidAnagram {

    /**
     * 计算字符串的每个字符的ascii码，如果找到相同的字符，则+1，最后计算数组是否相等
     * 只包含小写字母
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] buck = new int[26];
        for (Character source : s.toCharArray()) {
            buck[source - 'a']++;
        }
        for (Character destination : t.toCharArray()) {
            if (buck[destination - 'a'] == 0) {
                return false;
            }
            buck[destination - 'a']--;
        }
        return true;

    }

}
