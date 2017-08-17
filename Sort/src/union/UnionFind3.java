package union;

/**
 * Created by Administrator on 2017/6/6.
 */
public class UnionFind3 {
    private int[] parent;
    private int count;
    private int[] size;

    public UnionFind3(int count) {
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        this.count = count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while(parent[p] != p)
            p = parent[p];
        return p;
    }
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if( pRoot == qRoot )
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if( size[pRoot] < size[qRoot] ){
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else{
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
