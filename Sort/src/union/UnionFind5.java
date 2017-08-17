package union;

/**
 * Created by Administrator on 2017/6/6.
 */
public class UnionFind5 {
    private int[] rank;
    private int[] parent;
    private int count;

    public UnionFind5(int count) {
        rank = new int[count];
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        this.count = count;
    }
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    private int find(int p) {
        while(parent[p] != p){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
        // path compression 2, 递归算法
//        if( p != parent[p] )
//            parent[p] = find( parent[p] );
//        return parent[p];
    }

    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
