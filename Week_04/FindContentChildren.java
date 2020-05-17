import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 分发饼干
 * @author: qpy
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null && s == null && g.length == 0 && s.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort( g );
        Arrays.sort( s );
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
                si++;
                count++;
            } else {
                si++;
            }
        }
        return count;
    }
}
