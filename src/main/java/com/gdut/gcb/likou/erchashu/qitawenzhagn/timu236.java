package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/11 8:38
 * @Version 1.0
 **/
public class timu236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        // 递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 拼接递归结果
        if (left!=null&&right!=null){
            return root;
        }else if (left==null&&right==null){
            return null;
        }else {
            return left==null?right:left;
        }
    }
    
}
