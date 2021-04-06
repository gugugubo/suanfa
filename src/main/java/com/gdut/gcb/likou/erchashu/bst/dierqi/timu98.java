package com.gdut.gcb.likou.erchashu.bst.dierqi;

/**
 * @Author 古春波
 * @Description 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * @Date 2021/2/10 9:17
 * @Version 1.0
 **/

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最后总结
 *
 * 通过这篇文章，我们总结出了如下几个技巧：
 *
 * 1、如果当前节点会对下面的子节点有整体影响，可以通过辅助函数增长参数列表，借助参数传递信息。
 *
 * 2、在二叉树递归框架之上，扩展出一套 BST 代码框架：
 */
public class timu98 {

    public boolean isValidBST(TreeNode root) {
        return recur(root,null,null);
    }

    public boolean recur(TreeNode root, TreeNode max, TreeNode min){
        if (root==null){
            return true;
        }
        if (min!=null && root.val<=min.val){
            return false;
        }
        if (max!=null && root.val>=max.val){
            return false;
        }

        boolean leftResult = recur(root.left, root, min);

        boolean rightResult = recur(root.right, max, root);

        return leftResult && rightResult;
    }



    //    链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
    // 思路跟下面一样，都是使用中序遍历
    long pre = Long.MIN_VALUE;
    public boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }



    /**
     *     链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    
    public static void main(String[] args) {
        String[] strings = new String[]{"10","5","15","null","null","6","20"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        timu98 timu98 = new timu98();
        boolean validBST = timu98.isValidBST(treeNode);
        boolean validBST2 = timu98.isValidBST2(treeNode);
        System.out.println(validBST);
    }
}
