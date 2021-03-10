package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 17:02
 * @Version 1.0
 **/
public class timu543 {

    
    int max = 0;


    /**dfs， 此函数返回root为根节点的深度
     * 解法参考https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
       recur(root);
       return max;
    }
    
    public int recur(TreeNode root){
        if (root==null){
            return 0;
        }

        int leftDept = recur(root.left);  // 左子树的深度
        int rightDept = recur(root.right);  // 右子树的深度

        // 计算两颗子树的高度和就是roo最大的路径
        int thisRootMaxDept = leftDept+rightDept;

        max = Math.max(max, thisRootMaxDept);

        return Math.max(leftDept, rightDept) +1 ;  // 返回深度
    }
    
}
