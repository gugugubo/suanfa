package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/11 8:38
 * @Version 1.0
 **/
public class timu236 {

    // 关键思想：最近公共祖先的概念  决定了使用  后序遍历
    // 通过递归对二叉树进行后序遍历，当遇到节点 p 或 q 时返回。
    // 从底至顶回溯，1.当节点 p,q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root
    // 2.当p节点下包括q节点时，返回p节点   3. 当q节点下包括p节点时，返回q节点
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        // 递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 拼接递归结果
        if (left!=null&&right!=null){
            return root;
        }else if (left==null&&right==null){
            return null;
        }else {
            return left==null?right:left;
        }
    }
    
}
