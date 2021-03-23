package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description  437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 21:53
 * @Version 1.0
 **/
public class timu437 {


    /**
     * 递归和回溯，用到了一个叫做前缀和的概念
     * 解法参考：https://leetcode-cn.com/problems/path-sum-iii/solution/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/
     * https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
     * @param root
     * @param sum
     * @return
     */
    
    
    int sum ;
    HashMap<Integer, Integer> prefixMap ;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        prefixMap = new HashMap<>();
        // 前缀和为0的一条路径，  这个别漏了
        prefixMap.put(0, 1);
        return recur(root,0);
    }

    /**
     * 此函数返回root为根节点的路径总和为sum的路径的数目
     * @param root
     * @param currSum  当前节点的前缀和
     * @return
     */
    public int recur(TreeNode root, int currSum){
        
        // 1.base case 
        if(root==null){
            return 0;
        }
        
        int totalSum = currSum+root.val;

        Integer res = prefixMap.getOrDefault(totalSum - sum, 0);

        // 回溯代码
        prefixMap.put(totalSum, prefixMap.getOrDefault(totalSum,0) + 1);
        
        // 加上左右两边路径总和为sum的路径的数目
        res += recur(root.left, totalSum);
        res += recur(root.right, totalSum);

        // 回溯代码
        prefixMap.put(totalSum, prefixMap.get(totalSum)-1);
        
        return res;
    }


    /**
     *  作者：Geralt_U
     *     链接：https://leetcode-cn.com/problems/path-sum-iii/solution/437lu-jing-zong-he-iii-di-gui-fang-shi-by-ming-zhi/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *    双递归的方法
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum2(root.left,sum);
        int b = pathSum2(root.right,sum);
        return result+a+b;

    }
    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0;
        return result + countPath(root.left,sum) + countPath(root.right,sum);
    }

    
}
