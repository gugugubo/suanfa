package com.gdut.gcb.niuke.erchashu;

import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Date 2020/9/13 20:35
 * @Version 1.0
 * url https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 **/
public class timu68_1 {


    /**
     * dfs递归实现
     * 时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）。
     * 空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 N 。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        } 
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }


    /**
     * bfs 迭代
     * 时间复杂度 O(N)： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）。
     * 空间复杂度 O(1)： 使用常数大小的额外空间。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String[] ints = {"6","2","8","0","4","7","9","null","null","3","5"};
        TreeNode root = util.stringToTreeNode(ints);
        lowestCommonAncestor(root,root.left,root.right);
    }
}
