package bobo.algo.niuke.erchashu;

import bobo.algo.utils.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 古春波
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Date 2020/9/10 15:06
 * @Version 1.0
 * url https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 **/
public class timu07 {
    static HashMap<Integer, Integer> map = new HashMap<>();


    /**
     * 使用递归
     * 前序遍历的第一个是根节点
     * 中序遍历中找到这个根节点，然后这个根节点左边的值都是左子树的节点，右子树的值都是右子树的节点；
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode  buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = recur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }


    public static TreeNode recur(int[] preorder, int preStart, int preEnd ,
                                 int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preEnd == preStart){
            return node;
        }else {
            int index = map.get(preorder[preStart]);
            int preEnd2 = preStart + index - inStart;
            TreeNode left = recur(preorder, preStart + 1,   preEnd2, inorder, inStart, index-1);
            TreeNode right = recur(preorder, preEnd2 + 1, preEnd, inorder, index+1, inEnd);
            node.left = left;
            node.right = right;
            return node;
        }
    }


    /**
     * 时间复杂度 O(N) ： N 为树的节点数量。初始化 HashMap 需遍历 inorder ，占用 O(N) ；递归共建立 N 个节点，每层递归中的节点建立、搜索操作占用 O(1) ，因此递归占用 O(N) 。
     * （最差情况为所有子树只有左节点，树退化为链表，此时递归深度 O(N) ；平均情况下递归深度 O(log2N)）。
     * 空间复杂度 O(N) ： HashMap 使用 O(N) 额外空间；递归操作中系统需使用 O(N) 额外空间。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);

        }
        return recur2(preorder,0, 0, inorder.length - 1);
    }
    
    public static TreeNode recur2(int[] preorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int preEnd2 = preStart + index - inStart;
        TreeNode left = recur2(preorder, preStart+1, inStart+0,index-1);
        TreeNode right = recur2(preorder, preEnd2+1,index+1,   inEnd+0);
        node.left = left;
        node.right = right;
        return node;
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree(preorder, inorder);
        util.treeNodeToString(node);


    }
}
