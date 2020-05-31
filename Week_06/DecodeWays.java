/**
 * @program: algorithm
 * @description: 解码方法
 * @author: qpy
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int a = 1, b = 1, c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = b;
            b = a;
            char temp = s.charAt( i );
            if (temp == '0') {
                a = 0;
                continue;
            }
            if (i <= s.length() - 2) {
                int f = Integer.valueOf( s.substring( i, i + 2 ) );
                if (f > 9 && f < 27)
                    a += c;
            }
        }
        return a;
    }
}
