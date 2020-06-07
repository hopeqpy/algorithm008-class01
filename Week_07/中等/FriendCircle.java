package 中等;

/**
 * @program: algorithm
 * @description: 朋友圈
 * @author: qpy
 */
public class FriendCircle {

    public int findCircleNum(int[][] M) {
        int pc = M.length;
        UnionFind unionFind = new UnionFind( pc );
        for (int i = 0; i < pc; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    continue;
                }
                if (M[i][j] == 1) unionFind.union( i, j );
            }
        }
        return unionFind.count();
    }
}
