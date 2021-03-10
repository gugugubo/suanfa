package com.gdut.gcb.likou.erchashu.dierqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 *     二叉树的根是数组 nums 中的最大元素。
 *     左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 *     右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 *
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * @Date 2021/2/9 22:51
 * @Version 1.0
 **/
public class timu654 {


    /**
     * 自己做的递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = recur(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode recur(int[] nums, int start, int end){
        if (start>end){
            return null;
        }
        int maxIndex = start;
        for (int i=start; i<=end; i++){
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.right = recur(nums,maxIndex+1, end);
        root.left = recur(nums, start,maxIndex-1);
        return root;
    }

    public static void main(String[] args) {
        timu654 timu654 = new timu654();
        int[] ints = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = timu654.constructMaximumBinaryTree(ints);
        
    }
}
