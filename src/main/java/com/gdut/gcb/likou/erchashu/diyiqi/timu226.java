package com.gdut.gcb.likou.erchashu.diyiqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/3 23:43
 * @Version 1.0
 **/
public class timu226 {

    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
