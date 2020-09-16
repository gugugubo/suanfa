package bobo.algo.niuke.erchashu;

import bobo.algo.utils.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @Date 2020/9/13 19:28
 * @Version 1.0
 * url https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 **/
public class timu32_3 {


    /**
     * 迭代  
     * 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次，占用 O(N) ；双端队列的队首和队尾的添加和删除操作的时间复杂度均为 O(1)。
     * 空间复杂度 O(N) ： 最差情况下，即当树为满二叉树时，最多有 N/2个树节点 同时 在 deque 中，使用 O(N) 大小的额外空间。
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        if(root == null){
            return result;
        }
        
        LinkedList<TreeNode> nodes  = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            LinkedList<Integer> vals = new LinkedList<>();
            for (int i =nodes.size(); i>0 ; i--){
                TreeNode node = nodes.remove();       
                if(result.size() % 2 == 0) {
                    // 偶数层 -> 队列头部
                    vals.addLast(node.val); 
                }
                else {
                    // 奇数层 -> 队列尾部
                    vals.addFirst(node.val);
                }
                
                if (node.left!= null ){
                    nodes.add(node.left);
                }
                if (node.right!= null ){
                    nodes.add(node.right);
                }
            }
            result.add(vals);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] ints = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode node = util.stringToTreeNode(ints);
        levelOrder(node);
    }
    
}
