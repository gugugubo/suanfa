package com.gdut.gcb.niuke.erchashu;

import bobo.algo.utils.util;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 28. 对称的二叉树
 * @Date 2020/9/13 11:54
 * @Version 1.0
 * url https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 **/
public class timu28 {


    /**
     * 时间复杂度 O(N) ： 其中 N 为二叉树的节点数量，每次执行 recur() 可以判断一对节点是否对称，因此最多调用 N/2次 recur() 方法。
     * 空间复杂度 O(N) ： 最差情况下（见下图），二叉树退化为双×链表，系统使用 O(N) 大小的栈空间。
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){return true;}
        else { 
            return recur(root.left,root.right);
        }
    }

    public  static boolean recur(TreeNode left, TreeNode right){
        if (left == null && right== null){
            return true;
        }
        if (left == null || right == null ||left.val != right.val){
            return false;
        }
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
 
}
