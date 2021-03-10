package com.gdut.gcb.likou.erchashu.bst.dierqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 例如，
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 *
 * 你应该返回如下子树:
 *       2     
 *      / \   
 *     1   3
 *
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * @Date 2021/2/10 9:17
 * @Version 1.0
 **/
public class timu700 {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }else if(root.val>val){
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        timu700 timu700 = new timu700();
        String[] strings = new String[]{"4","2","7","1","3"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        TreeNode treeNode1 = timu700.searchBST(treeNode, 2);
        System.out.println(treeNode1);
    }
}
