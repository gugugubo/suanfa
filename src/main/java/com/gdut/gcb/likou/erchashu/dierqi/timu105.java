package com.gdut.gcb.likou.erchashu.dierqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Date 2021/2/9 22:51
 * @Version 1.0
 **/
public class timu105 {
    HashMap<Integer, Integer> preMap;
    HashMap<Integer, Integer> inMap ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){
            return null;
        }
        preMap = new HashMap<>();
        inMap = new HashMap<>();
        for (int i=0; i<preorder.length; i++){
            preMap.put(preorder[i],i);
            inMap.put(inorder[i],i);
        }
        return recur(preorder,0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode recur(int[] preorder, int preStart , int preEnd,int[] inorder, int inStart, int inEnd){
     

        if (inStart>inEnd || preStart>preEnd){
            return null;
        }
      
        int rootValue = preorder[preStart];

        Integer rootIndex = inMap.get(rootValue);
        int leftNums = rootIndex - inStart;  // 左子树的元素个数
        int rightNums = inEnd - rootIndex;  // 右子树的元素个数
        TreeNode root = new TreeNode(rootValue);

        root.left = recur(preorder, preStart+1,preStart+leftNums,inorder, inStart, rootIndex-1);
        root.right = recur(preorder, preStart+leftNums+1, preEnd, inorder,rootIndex+1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        timu105 timu105 = new timu105();
        int[] ints = new int[]{3,9,20,15,7};
        int[] ints1 = new int[]{9,3,15,20,7};
        TreeNode treeNode = timu105.buildTree(ints, ints1);
        
    }
}
