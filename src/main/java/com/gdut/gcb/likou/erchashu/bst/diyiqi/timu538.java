package com.gdut.gcb.likou.erchashu.bst.diyiqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 *     节点的左子树仅包含键 小于 节点键的节点。
 *     节点的右子树仅包含键 大于 节点键的节点。
 *     左右子树也必须是二叉搜索树。
 *
 * @Date 2021/2/10 9:16
 * @Version 1.0
 **/
public class timu538 {

    int sum ;
    public TreeNode convertBST(TreeNode root) {
        recur2(root);
        return root;
    }

    /**
     * 解法参考https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=21#wechat_redirect
     * @param root
     */
    void recur2(TreeNode root) {
        if (root==null){
            return;
        }
        recur2(root.right);
        sum+=root.val;
        root.val = sum;
        recur2(root.left);
    }

    /**
     * 下面是这个自己尝试做的，没做出来
     * @param root
     * @param rigValue
     * @return
     */
    public int recur(TreeNode root, int rigValue){
        if (root==null){
            return 0;
        }
        int rightValue = recur(root.right, 0);

        root.val = root.val + rightValue + rigValue;

        int leftValue = recur(root.left, root.val);
        
        
        return leftValue + root.val;

    }

    public static void main(String[] args) {
        timu538 timu538 = new timu538();
        String[] strings = new String[]{"4","1","6","0","2","5","7","null","null","null","3","null","null","null","8"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        TreeNode treeNode1 = timu538.convertBST(treeNode);
        System.out.println(treeNode1);

    }
}
