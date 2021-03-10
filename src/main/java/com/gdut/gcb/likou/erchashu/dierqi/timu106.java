package com.gdut.gcb.likou.erchashu.dierqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Date 2021/2/9 22:51
 * @Version 1.0
 **/
public class timu106 {


    HashMap<Integer, Integer> preMap;
    HashMap<Integer, Integer> inMap ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0){
            return null;
        }
        preMap = new HashMap<>();
        inMap = new HashMap<>();
        for (int i=0; i<postorder.length; i++){
            preMap.put(postorder[i],i);
            inMap.put(inorder[i],i);
        }
        return recur(postorder,0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode recur(int[] postorder, int proStart , int proEnd,int[] inorder, int inStart, int inEnd){


        if (inStart>inEnd || proStart>proEnd){
            return null;
        }

        int rootValue = postorder[proEnd];

        Integer rootIndex = inMap.get(rootValue);
        int leftNums = rootIndex - inStart;  // 左子树的元素个数
        int rightNums = inEnd - rootIndex;  // 右子树的元素个数
        TreeNode root = new TreeNode(rootValue);

        root.left = recur(postorder, proStart,proStart+leftNums-1,inorder, inStart, rootIndex-1);
        root.right = recur(postorder, proStart+leftNums, proEnd-1, inorder,rootIndex+1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        timu106 timu106 = new timu106();
        int[] ints = new int[]{5,6,7,4,2,8,9,3,1};
        int[] ints1 = new int[]{5,2,6,4,7,1,8,3,9};
        TreeNode treeNode = timu106.buildTree(ints1, ints);

    }
}
