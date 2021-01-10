package com.gdut.gcb.niuke.erchashu;

/**
 * @Author 古春波
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @Date 2020/9/13 22:02
 * @Version 1.0
 * url https://leetcode-cn.com/problems/er-cha-shu-de-zi-jin-gong-gong-zu-xian-lcof/
 **/
public class timu68_2 {


    /**
     * 递归
     * 时间复杂度 O(N) ： 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N) ： 最差情况下，递归深度达到 N ，系统使用 O(N) 大小的额外空间。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val){return root;}
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null){return right;}
        if (right == null){return left;}
        return root;
    }
}
