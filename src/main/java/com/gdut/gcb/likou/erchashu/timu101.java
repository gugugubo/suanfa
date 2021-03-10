package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @Date 2021/2/17 20:05
 * @Version 1.0
 **/
public class timu101 {


    /**
     * 递归：完全自己做的，感觉不错hh
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return recur(root.left, root.right);
    }
    
    
    public boolean recur(TreeNode left , TreeNode right){
         if (left==null&&right!=null){
             return false;
         }
         if (right==null&&left!=null){
             return false;
         }
         if (left==null && right==null){
             return true;
         }
         if (left.val != right.val){
             return false;
         }
         return recur(left.left, right.right) && recur(left.right, right.left);
    }


    /**
     * 迭代
     * 解法参考：    链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
//        return check(root, root);
        // 上面的这个是官方的，下面这个是我自己的，官方的会导致判断两遍
        if (root==null){
            return true;
        }
        return check(root.left, root.right);
    }
    

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"1","2","2","3","4","4","3"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        timu101 timu101 = new timu101();
        timu101.isSymmetric3(treeNode);
    }

}
