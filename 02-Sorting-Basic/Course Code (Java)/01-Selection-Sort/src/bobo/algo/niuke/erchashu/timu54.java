package bobo.algo.niuke.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 二叉搜索树的第k大节点
 * @Date 2020/9/13 11:04
 * @Version 1.0
 * url https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 **/
public class timu54 {


    int k;
    int result ;
    
    /**
     * 使用dfs  中序遍历
     * 时间复杂度 O(N)： 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N ，占用 O(N) 时间。
     * 空间复杂度 O(N)： 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    /**
     * dfs  使用中序遍历的倒序
     * @param node
     */
    public void dfs(TreeNode node){

        if (node == null){return;}

        dfs(node.right);

        k--;
        if (k == 0){
            result = node.val;
        }
        
        dfs(node.left);

    }
    
}
