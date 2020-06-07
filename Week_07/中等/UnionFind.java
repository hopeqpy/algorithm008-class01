package 中等;

/**
 * @program: algorithm
 * @description: 并查集
 * @author: qpy
 */
public class UnionFind {

    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            size[i] = 1;
        }
    }


    public int find(int p) {
        while (parent[p] != p) {
            // 进行路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find( p );
        int qRoot = find( q );
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += 1;
        }
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count(){
        return this.count;
    }
}
