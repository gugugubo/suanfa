package com.gdut.gcb.likou.erchashu.bst.diyiqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * @Date 2021/2/10 9:16
 * @Version 1.0
 **/
public class timu230 {

    int res ;
    int k ;

    public int kthSmallest(TreeNode root, int k) {
         this.k = k;   
         recur(root);
         return res;
    }
    
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        // 进行中序遍历
        recur(root.left);
 
        k--;
        if (k==0) {
            this.res = root.val;
            return;
        }
        recur(root.right);
    }

    public static void main(String[] args) {
        timu230 timu230 = new timu230();
        String[] strings = new String[]{"3","1","4","null","2"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        int i = timu230.kthSmallest(treeNode, 1);
        System.out.println(i);
    }
    
}
