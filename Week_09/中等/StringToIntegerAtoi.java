package 中等;

/**
 * @program: algorithm
 * @description: 字符串轉整數
 * @author: qpy
 */
public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < length && charArray[i] == ' ') {
            i++;
        }
        if (i == length) {
            return 0;
        }
        int temp = 1;
        char left = charArray[i];
        if (left == '+') {
            i++;
        } else if (left == '-') {
            i++;
            temp = -1;
        }
        int result = 0;
        while (i < length) {
            char cur = charArray[i];
            if (cur > '9' || cur < '0') {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (cur - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (cur - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + temp * (cur - '0');
            i++;
        }
        return result;

    }
}
