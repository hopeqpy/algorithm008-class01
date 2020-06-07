package 困难;

import java.util.*;
import java.util.HashSet;

/**
 * @program: algorithm
 * @description: N皇后
 * @author: qpy
 */
public class NQueens {
    private List<List<String>> result = new ArrayList<List<String>>();
    private int n;
    //攻击的标记
    HashSet<Integer> columns = new HashSet<Integer>();
    HashSet<Integer> pie = new HashSet<Integer>();
    HashSet<Integer> na = new HashSet<Integer>();

    //初始化
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        recursive( new ArrayList<>(), 0 );
        return result;
    }

    private void recursive(List<String> queen, int row) {
        if (queen.size() == n) {
            result.add( new ArrayList<String>( queen ) );
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains( i )
                    || pie.contains( row + i )
                    || na.contains( n + row - i )) {
                continue;
            }
            columns.add( i );
            pie.add( row + i );
            na.add( n + row - i );

            StringBuilder builder = new StringBuilder( "" );
            for (int j = 0; j < n; i++) {
                if (j == i) {
                    builder.append( "Q" );
                } else {
                    builder = builder.append( "." );
                }
            }
            queen.add( builder.toString() );
            recursive( queen, row + 1 );
            columns.remove( i );
            pie.remove( row + i );
            na.remove( n + row - i );
            queen.remove( queen.size() - 1 );
        }
    }
}
