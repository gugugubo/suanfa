package com.gdut.gcb.likou.diguihehuisu;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/19 20:53
 * @Version 1.0
 **/
public class timu129 {


    /**递归
     * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int prevSum) {
        if (root==null){
            return;
        }
        prevSum  = prevSum*10 + root.val;
        if (root.left ==null && root.right==null){
            res += prevSum;
        }
        dfs(root.left, prevSum);
        dfs(root.right, prevSum);
    }


    /** 层序遍历
     *     链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
     * @param root
     * @return
     */
    public int sumNumbers3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        // 用这个队列记录了结点的前缀路径组成的数字
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
    


    int res = 0;
    LinkedList<Integer> nums = new LinkedList<>();
    // 自己做的，是错误的，题目要求的是计算从根到叶子节点生成的所有数字之和，但是我计算的不是到叶子节点的
    public int sumNumbers2(TreeNode root) {
        recur(root);
        return res;
    }
    public void recur(TreeNode root){
        if (root == null){
            StringBuffer stringBuffer = new StringBuffer();
            for (int num : nums){
                stringBuffer.append(num);
            }
            res += Integer.valueOf(stringBuffer.toString());
            return;
        }
        nums.addLast(root.val);
        recur(root.left);
        recur(root.right);
        nums.removeLast();
    }

    public static void main(String[] args) {
        Object[] objects = new Object[]{4,9,0,null,1};
        TreeNode strings = util.intToTreeNode(objects);
        timu129 timu129 = new timu129();
        int i = timu129.sumNumbers2(strings);
        System.out.println(i);
    }
}
