package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author  古春波
 * @Description 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 21:53
 * @Version 1.0
 **/
public class timu112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recur(root, targetSum);
    }


    public boolean recur(TreeNode root, int targetSum){
        if (root==null){
            return false;
        }
        if (root.left == null && root.right == null  && root.val == targetSum){
            return true;
        }
        boolean leftResult = recur(root.left, targetSum - root.val);
        if (leftResult){
            return true;
        }
        boolean rightResult = recur(root.right, targetSum - root.val);
        return rightResult;
    }
    
}
