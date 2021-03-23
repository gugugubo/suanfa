package com.gdut.gcb.likou.erchashu.bianli;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 古春波
 * @Description 二叉树的非递归遍历方式
 * https://blog.csdn.net/z_ryan/article/details/80854233
 * @Date 2021/3/12 22:54
 * @Version 1.0
 **/
public class feidiguibianli {


    public boolean zhognxubianli(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
        return true;
    }

    // 二叉树的前序遍历
    public boolean qianxubianli(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return true;
    }
}
