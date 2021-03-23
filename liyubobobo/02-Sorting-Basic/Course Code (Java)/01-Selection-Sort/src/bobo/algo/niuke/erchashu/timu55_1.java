package bobo.algo.niuke.erchashu;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Date 2020/9/11 17:02
 * @Version 1.0
 * url : https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

 **/
public class timu55_1 {


    /**
     * 递归遍历：dfs
     * 时间复杂度 O(N) ： N 为树的节点数量，计算树的深度需要遍历所有节点。
     * 空间复杂度 O(N) ： 最差情况下（当树退化为链表时），递归深度可达到 N 。
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null){return 0;}

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return left > right ?  left+1 :right+1;
    }
    
    
    /**
     * 使用bfs层次遍历
     * 时间复杂度 O(N) ： N 为树的节点数量，计算树的深度需要遍历所有节点。
     * 空间复杂度 O(N) ： 最差情况下（当树平衡时），队列 queue 同时存储 N/2N 个节点。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 特例处理： 当 root​ 为空，直接返回 深度 0。
        if(root == null){
            return 0;
        }

        // 队列 queue （加入根节点 root ），计数器 res = 0。
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<TreeNode> var ;
        int total = 0;
        
        nodes.add(root);
        
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
            nodes = var;
            total ++ ;
        }
        
        return total;
    }
}
