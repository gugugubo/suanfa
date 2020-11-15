package com.gdut.gcb.likou.bingchaji;

/**
 * @Author 古春波
 * @Description 我们的第二版Union-Find
 * @Date 2020/10/1 23:36
 * @Version 1.0
 **/
public class UnionFind2 {
    
    int[] parent;

    /**
     * 数据个数
     */
    private int count;

    public UnionFind2(int count){
        parent = new int[count];
        this.count = count;

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0 ; i< count ; i++){
            parent[i] = i;
        }
    }

    /**
     * 查找id编号为p所属集合的根节点
     * O(h)复杂度, h为树的高度
     */
    private int find(int p){
        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    /**
     * 判断id编号为p和为q的元素是否在同一个集合
     * O(h)复杂度, h为树的高度
     */
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 合并id编号为p和为q的元素所在集合
     *  O(h)复杂度, h为树的高度
     */
    public void unionElements(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        
        if (proot == qroot){
            return;
        }
        parent[proot] = qroot;
    }
    
}
