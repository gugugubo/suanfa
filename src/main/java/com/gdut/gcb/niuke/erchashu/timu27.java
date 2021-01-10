package com.gdut.gcb.niuke.erchashu;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @Date 2020/9/12 13:30
 * @Version 1.0
 * url  https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 **/
public class timu27 {


    /**
     * 使用递归
     * 时间复杂度 O(N) ： 其中 N 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N) 时间。
     * 空间复杂度 O(N) ： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N) 大小的栈空间。
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){return null;}

        TreeNode rightNode = mirrorTree(root.right);
        TreeNode leftNode = mirrorTree(root.left);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }


    /**
     * 使用迭代  辅助栈（或队列）  自己做的
     * 时间复杂度 O(N)： 其中 N 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N) 时间。
     * 空间复杂度 O(N)： 最差情况下（当为满二叉树时，每次都会新加入一个节点），栈 stack最多同时存储 N/2 个节点，占用 O(N) 额外空间。
     * @param root
     * @return
     */
    public static TreeNode mirrorTree2(TreeNode root) {
        if (root  == null ){return root;}
        
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            TreeNode left = node.left;
            if (left!=null){
                nodes.add(left);
            }
            TreeNode right = node.right;
            if (right!=null){
                nodes.add(right);
            }
            node.left = right;
            node.right = left;
        }
        
        return root;
    }


    /**
     * 使用 LinkedList 
     * @param root
     * @return
     */
    public static TreeNode mirrorTree3(TreeNode root) {
        if (root  == null ){return root;}
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            TreeNode node = nodes.removeLast();
            TreeNode left = node.left;
            if (left!=null){
                nodes.add(left);
            }
            TreeNode right = node.right;
            if (right!=null){
                nodes.add(right);
            }
            node.left = right;
            node.right = left;
        }
        return root;
    }
    
    public static void main(String[] args) {
        String[] strings = {"4", "null", "7", "1", "3", "6", "9"};
        TreeNode root = util.stringToTreeNode(strings);
        String s = util.treeNodeToString(root);
        System.out.println(s);
        mirrorTree2(root);
        s = util.treeNodeToString(root);
        System.out.println(s);
    }
}
