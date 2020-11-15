package com.gdut.gcb.niuke.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @Date 2020/9/13 17:52
 * @Version 1.0
 * url https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 **/
public class timu32_2 {


    /**
     * 迭代，参考timu55_1 的解法
     * 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
     * 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<TreeNode> var ;

        nodes.add(root);
        ArrayList<Integer> rootVal = new ArrayList<>();rootVal.add(root.val);   result.add(rootVal);
        
     
        while (!nodes.isEmpty()){
            // 这个记得每次需要更新为null，此题的核心就是：使用这个list存树的一层中的所有元素，如此一层层叠加就行了
            var =  new LinkedList<>();
            for (TreeNode node : nodes){
                if (node.left!= null ){
                    var.add(node.left);
                }
                if (node.right!= null ){
                    var.add(node.right);
                }
            }
            if (!var.isEmpty()){
                ArrayList<Integer> vals = new ArrayList<>();
                var.forEach(node ->vals.add(node.val));
                result.add(vals);
            }
            nodes = var;
        }

        return result;
    }


    /**
     * 递归，参考timu32_1的题解
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        levelHelper(result,root,0);

        return result;
        
    }
    public void levelHelper(List<List<Integer>> result , TreeNode root , int height){
        if (root == null){return ;}

        if (result.size() <= height){
            result.add(new ArrayList<>());
        }

        result.get(height).add(root.val);

        levelHelper(result,root.left, height+1);
        levelHelper(result,root.right,height+1);
    }
}
