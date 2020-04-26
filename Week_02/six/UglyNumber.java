package six;

import java.util.*;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @description: 丑数  --暴力破解
 * @author: qpy
 */
public class UglyNumber {

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add( 1 );
        int a = 0;
        int b = 0;
        int c = 0;
        while (list.size() != n) {
            int temp1 = list.get( a ) * 2;
            int temp2 = list.get( b ) * 3;
            int temp3 = list.get( c ) * 5;
            int min = Math.min( temp1, Math.min( temp2, temp3 ) );
            if (min == temp1) {
                temp1++;
            }
            if (min == temp2) {
                temp2++;
            }
            if (min == temp3) {
                temp3++;
            }
            list.add( min );
        }
        return list.get( n - 1 );
    }
}
