package bobo.algo.niuke.erchashu;

/**
 * @Author 古春波
 * @Description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @Date 2020/9/13 15:22
 * @Version 1.0
 * 二叉树的深度  
 * url https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 **/
public class timu55_2 {

    boolean result = true;


    /**
     * 递归dfs  参考二叉树的深度自己做出来的
     * 时间复杂度 O(N)： N 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return result;
    }

    public int recur(TreeNode root){
        if (root == null){return 0;}
        if (result != true){
            return -1;
        }
        int left = recur(root.left);
        if (result != true){
            return -1;
        }
        int right = recur(root.right);
        if (left > right +1 || right > left+1){
            result =false;
        }
        return  left > right ?  left+1 :right+1;
    }
}
