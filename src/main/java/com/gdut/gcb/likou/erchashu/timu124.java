package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author  古春波
 * @Description 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/17 10:47
 * @Version 1.0
 **/
public class timu124 {

    int max = Integer.MIN_VALUE;


    /**
     * 解法参考：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
     * 
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        recur(root);
        return max;
    }


    /**
     * 该函数计算二叉树中的一个节点的最大贡献值，具体而言，就
     * 是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大
     * @param root
     * @return
     */
    public int recur(TreeNode root) {
        if (root==null){
            return 0;
        }

        // 这个if不要也是可以的
        if (root.left==null && root.right==null){
            if ( root.val>max){
                max =  root.val;
            }
            return root.val;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(recur(root.left),0);
        int right = Math.max(recur(root.right),0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + left + right;
        // 更新答案
        if (priceNewpath>max){
            max = priceNewpath;
        }
        return root.val + Math.max(left, right);
    }


    /**
     * 下面是自己做的，只能通过部分测试用例
     * @param root
     * @return
     */
    public int maxPathSum2(TreeNode root) {
        recure2(root);
        return max;
    }
    
    public int recure2(TreeNode root) {
        
        if (root==null){
            return 0;
        }

        if (root.left==null && root.right==null){
            if ( root.val>max){
                max =  root.val;
            }
            return root.val;
        }
        
        int left = recure2(root.left);
        int right = recure2(root.right);
        int curmax = Integer.MIN_VALUE;
        if (left>curmax){
            curmax = left;
        }
        if (right>curmax){
            curmax = right;
        }
        // 错误在于这里没有对left 和right小于零的情况进行判断
        if (left+right+root.val>curmax){
            curmax = left+right+root.val;
        } 
        if (root.val>curmax){
            curmax = root.val;
        }
        if (curmax>max){
            max = curmax;
        }
        return root.val + Math.max(left, right);
    }
    
    
    
    
}
