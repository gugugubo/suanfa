package com.gdut.gcb.niuke.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Date 2020/9/12 17:09
 * @Version 2.0
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 **/
public class timu32_1 {


    /**
     * 迭代： 借用队列结构 自己做的
     * 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
     * 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {return new int[0];}

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node.left!= null){queue.add(node.left);}
            if (node.right!= null){queue.add(node.right);}
            result.add(node.val);
        }
        int[] rel = new int[result.size()];
        for (int i=0;i<result.size();i++){
            rel[i] =  result.get(i);
        }
        return rel;
    }


    /**
     * 使用递归解决问题
     * @param root
     * @return
     */
    public int[] levelOrder2(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        levelHelper(result,root,0);

        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            tempList.addAll(result.get(i));
        }

        //把list转化为数组
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;

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
