package bobo.algo.likou.bingchaji;

/**
 * 我们的第一版Union-Find，Union-Find就是并查集的意思
 */
public class UnionFind1 {

    /**
     * 我们的第一版Union-Find本质就是一个数组
     */
    private int[] id;     
    /**
     * 数据个数
     */
    private int count;    

    public UnionFind1(int n) {
        count = n;
        id = new int[n];
        
        // 我们用0--9给每个元素一个id编号，对于每一个元素，并查集存储的是元素它所属于的集合的id
        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
        for (int i = 0; i < count; i++)
            if (id[i] == pID)
                id[i] = qID;
    }
}
