package com.gdut.gcb.niuke.erchashu;

/**
 * @Author 古春波
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @Date 2020/9/11 19:19
 * @Version 1.0
 **/
public class timu36 {
    Node pre ;
    Node head ;
    public Node treeToDoublyList(Node root) {
        if (root == null) {return null;}
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
        
    }


    /**
     * dfs  使用中序遍历
     * @param node
     */
    public void dfs(Node node){
        
        if (node == null){return;}
        
        dfs(node.left);
        
        
        //维护前一个的节点
        if (pre!= null){
            pre.right = node;
        }else {head = node;}

        //维护后一个的节点
        node.left = pre;
        
        pre = node;
        dfs(node.right);
        
    }
    
}
