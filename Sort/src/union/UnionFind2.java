package union;

/**
 * Created by Administrator on 2017/6/6.
 */
public class UnionFind2 {
    private int[] parent;
    private int count;

    public UnionFind2(int count) {
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
        this.count = count;
    }
    private int find(int p){
        assert( p >= 0 && p < count );
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while( p != parent[p] )
            p = parent[p];
        return p;
    }
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot )
            return;
        parent[pRoot] = qRoot;
    }
}
