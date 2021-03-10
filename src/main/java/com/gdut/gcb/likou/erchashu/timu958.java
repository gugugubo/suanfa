package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *
 *
 * 示例 1：输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/17 22:49
 * @Version 1.0
 **/
public class timu958 {


    /**
     * 参考题解：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/er-cha-shu-de-wan-quan-xing-jian-yan-by-leetcode/
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                // 对比参考题解加了这个判断，这个判断可要可不要
                if (anode.node.left!=null){
                    nodes.add(new ANode(anode.node.left, anode.code * 2));
                }
                if (anode.node.right!=null){
                    nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
                }
            }
        }
        // 比较最后一个元素的code是否等于size
        return nodes.get(i-1).code == nodes.size();
    }

    /**
     * 参考上面的代码自己写的
     * @param root
     * @return
     */
    public boolean isCompleteTree2(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            // 注意这里修改了
            if (anode.code!=i){
                return false;
            }
            if (anode.node != null) {
                // 对比参考题解加了这个判断，这个判断可要可不要
                if (anode.node.left!=null){
                    nodes.add(new ANode(anode.node.left, anode.code * 2));
                }
                if (anode.node.right!=null){
                    nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
                }
            }
        }
        // 注意这里修改了
        return true;
    }
    
    class ANode {  // Annotated Node
        TreeNode node;
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public static void main(String[] args) {
        timu958 timu958 = new timu958();
        String[] strings = new String[]{"1","2","3","4","null","6","7"};
        TreeNode treeNode = util.stringToTreeNode(strings);
        boolean completeTree = timu958.isCompleteTree(treeNode);
        System.out.println(completeTree);
    }
}
