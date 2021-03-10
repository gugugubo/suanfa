package com.gdut.gcb.likou.erchashu.disanqi;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 古春波
 * @Description 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 *
 * 和
 *
 *     4
 *
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * @Date 2021/2/10 0:51
 * @Version 1.0
 **/
public class timu652 {

    HashMap<String, Integer> map = new HashMap<>();

    List<TreeNode> list = new ArrayList<>();

    /**
     * 解法参考：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=21#wechat_redirect
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        recur(root);
        return list;
    }
    
    
    public String recur(TreeNode node){
        if (node==null){
            return "#";
        }
        String left = recur(node.left);
        String right = recur(node.right);
        
        StringBuffer result = new StringBuffer();
        result.append(left).append(",").append(right).append(",").append(node.val);
//        result.append(left).append(right).append(node.val);  这条语句不行，因为可能回造成 两个节点都是2和只有一个节点但是值为22
        String res = result.toString();
        Integer nums = map.getOrDefault(res, 0);
        if (nums==1){
            list.add(node);
        }
        map.put(res,nums+1);
        return res;
    }

    public static void main(String[] args) {
        String[]  ints = new String[]{"10","2","22","1","12","1","1"};
        TreeNode treeNode = util.stringToTreeNode(ints);
        List<TreeNode> duplicateSubtrees = new timu652().findDuplicateSubtrees(treeNode);
        System.out.println(duplicateSubtrees);
    }
}
