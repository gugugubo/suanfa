package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/10 23:27
 * @Version 1.0
 **/
public class timu222 {

    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        TreeNode left = root, right = root;
        int leftNums=0, rightNums=0;
        while (left!=null){
            leftNums++;
            left = left.left;
        }
        while (right!=null){
            rightNums++;
            right = right.right;
        }
        if (leftNums==rightNums){
            return (int)Math.pow(2, leftNums) - 1;
        }else {
            return 1+countNodes(root.left) + countNodes(root.right);
        }
    }
    
}
