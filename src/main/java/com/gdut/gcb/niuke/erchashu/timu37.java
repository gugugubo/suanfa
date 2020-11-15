package com.gdut.gcb.niuke.erchashu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 请实现两个函数，分别用来序列化和反序列化二叉树。
 * @Date 2020/9/12 22:00
 * @Version 1.0
 * url https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 **/
public class timu37 {

    /**
     * 序列化，迭代
     * 时间复杂度 O(N) ： N为二叉树的节点数，层序遍历需要访问所有节点，最差情况下需要访问 N+1 个 null ，总体复杂度为 O(2N+1)=O(N)。
     * 空间复杂度 O(N) ： 最差情况下，队列 queue 同时存储 （N+1）/2个节点（或 N+1 个 null），使用 O(N) ；列表 res 使用 O(N)
     * @param root
     * @return
     */
    public  static String serialize(TreeNode root) {
        if (root == null){return "[]";}

        StringBuffer string = new StringBuffer();
        string.append("[");
        if (root == null){string.append("]");return string.toString();}

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){

            TreeNode node = nodes.poll();
            if (node != null){
                string.append(node.val + ",");

                nodes.add(node.left);
                nodes.add(node.right);
            }else {
                string.append("null,");
            }
        }

        string.deleteCharAt(string.length() -1);
        string.append("]");
        return string.toString();


    }


    /**
     * 反序列化，迭代
     * 时间复杂度 O(N) ： N 为二叉树的节点数，按层构建二叉树需要遍历整个 vals ，其长度最大为 2N+1 。
     * 空间复杂度 O(N) ： 最差情况下，队列 queue 同时存储 (N+1)/2个节点，因此使用 O(N)额外空间
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")) {return null;}
        String[] parts = data.substring(1,data.length()-1).split(",");

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        int index = 1;
        String item;
        while (!nodes.isEmpty()){

            TreeNode node = nodes.remove();
            if (index > parts.length -1){
                break;
            }

            item = parts[index++];
            if (!"null".equals(item)){
                String val = item;
                TreeNode leftNode = new TreeNode(Integer.parseInt(val));
                node.left = leftNode;
                nodes.add(leftNode);
            }

            if (index > parts.length -1){
                break;
            }
            item = parts[index++];
            if (!"null".equals(item)){
                String val = item;
                TreeNode rightNode = new TreeNode(Integer.parseInt(val));
                node.right = rightNode;
                nodes.add(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String string   =  "[1,2,3,null,null,4,5]";
        TreeNode node = deserialize(string);
        String serialize = serialize(node);
        System.out.println(serialize);
        node = deserialize(string);
    }
}
