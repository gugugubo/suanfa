package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author  古春波
 * @Description 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 21:53
 * @Version 1.0
 **/
public class timu113 {

    /**
     * 一看就是典型的递归和回溯问题
     * @param root
     * @param targetSum
     * @return
     */

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recur(root, targetSum);
        return res;
    }
    
    
    public void recur(TreeNode root, int targetSum){
        if (root==null){
            return;
        }
        
        if (root.left == null && root.right == null  && root.val == targetSum){
            path.addLast(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        
        path.addLast(root.val);
        recur(root.left, targetSum-root.val);
        recur(root.right, targetSum-root.val);
        path.removeLast();
    }
    
}
