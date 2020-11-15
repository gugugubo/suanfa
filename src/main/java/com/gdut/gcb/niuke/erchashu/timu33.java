package com.gdut.gcb.niuke.erchashu;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Date 2020/9/11 20:45
 * @Version 1.0
 * url https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 **/
public class timu33 {

    /**
     * 递归分治
     * 时间复杂度 O(N2) ： 每次调用 recur(i,j)减去一个根节点，因此递归占用 O(N) ；最差情况下（即当树退化为链表），每轮递归都需遍历树所有节点，占用 O(N) 。
     * 空间复杂度 O(N) ： 最差情况下（即当树退化为链表），递归深度将达到 N 。
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    
    boolean recur(int[] postorder, int i, int j) {
        // 终止条件
        if (i >= j ){
            return true;
        }
        
        int first,var=i;
        // 划分左右子树
        while (postorder[var] <postorder[j]){
            var ++;
        }
        first = var ;
        // 划分左右子树
        while (postorder[var] > postorder[j]){
            var ++;
        }
        // 判断是否为二叉搜索树
        return var==j && recur(postorder, i ,first-1) && recur(postorder,first,j-1);
    }
    
    

}
