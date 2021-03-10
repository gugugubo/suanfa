package com.gdut.gcb.likou.erchashu.diyiqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 *     展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *     展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 0:04
 * @Version 1.0
 **/
public class timu114 {

    public void flatten(TreeNode root) {
        
        if (root == null){
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        // 3、将原先的右子树接到当前右子树的末端
        p.right = right;
        
    }
    
    
}
