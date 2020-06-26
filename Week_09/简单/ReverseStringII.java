package 简单;


import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 反转字符串2
 * @author: qpy
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            int j = Math.min( i + k - 1, charArray.length - 1 );
            reverse( charArray, i, j );
            i += 2 * k;
        }
        return String.valueOf( charArray );
    }

    /**
     * 反转
     *
     * @param charArray
     * @param i
     * @param j
     */
    private void reverse(char[] charArray, int i, int j) {
        while (i < j) {
            char temp = charArray[i];
            charArray[i++] = charArray[j];
            charArray[j--] = temp;
        }
    }


}
