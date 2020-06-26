package 简单;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 反转字符串中的单词
 * @author: qpy
 * @create: 2020-06-26 17:44
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] sArray = s.trim().split( " " );
        int length = sArray.length;
        StringBuilder result = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            if (sArray[i].equals( "" )) {
                continue;
            }
            result.append( sArray[i] + " " );
        }
        return result.toString().trim();
    }

}
