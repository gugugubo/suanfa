package com.gdut.gcb.likou.diguihehuisu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/5 19:29
 * @Version 1.0
 **/
public class timu99 {


    //     链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历二叉树，并将遍历的结果保存到list中        
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }


    //用两个变量x，y来记录需要交换的节点
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;

    public void recoverTree2(TreeNode root) {
        dfs2(root);
        //如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
    private void dfs2(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs2(node.left);
        if (pre == null) {
            pre = node;
        } else {
            if (pre.val > node.val) {
                y = node;
                if (x == null) {
                    x = pre;
                }
            }
            pre = node;
        }
        dfs2(node.right);
    }


    //莫里斯遍历 空间复杂度可以达到 O(1)
    public void recoverTree3(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        TreeNode tmp = null;
        while (root != null) {
            if (root.left != null) {
                tmp = root.left;
                while (tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    if (pre != null && pre.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            } else {
                if (pre != null && pre.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }


}
