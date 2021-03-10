package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 530. 二叉搜索树的最小绝对差给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Date 2021/2/27 21:13
 * @Version 1.0
 **/
public class timu530 {


    /**
     * 使用中序遍历
     * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/er-cha-sou-suo-shu-de-zui-xiao-jue-dui-chai-by-lee/
     * @param root
     * @return
     */
    
    int min = Integer.MAX_VALUE;
    int pre =-1;
    public int getMinimumDifference(TreeNode root) {
        recur(root);
        return min;
    }
    
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        recur(root.left);
        if (pre == -1) {
            pre = root.val;
        }else {
            min = Math.min(min, root.val-pre);
            pre = root.val;
        }
        recur(root.right);
    }
    
    
}
