package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * @Date 2021/2/4 1:33
 * @Version 1.0
 **/
public class timu111 {

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return recur(root);
    }
    
    public int recur(TreeNode root){
        if (root == null){return 0;}

        if (root.right==null && root.left==null){
            return 1;
        }
        else if (root.right==null ){
            return recur(root.left) + 1;
        }
        else if (root.left==null ){
            return recur(root.right) + 1;
        }else {
            int left = recur(root.left);
            int right = recur(root.right);
            return left < right ?  left +1:right +1;
        }
    }

    /**
     * 下面这种是不对的，返回的不是叶子节点的深度
     * @param root
     * @return
     */
    public int recur2(TreeNode root){
        if (root == null){return 0;}
        int left = recur(root.left);
        int right = recur(root.right);
        return left < right ?  left +1:right +1;
    }



    public static void main(String[] args) {
        TreeNode node = util.stringToTreeNode(new String[]{"-2","0","-1","null","3","0","null","6","null","5","-5"});
        new timu111().minDepth(node);
    }

    int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
}
