package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * @Date 2021/3/6 11:15
 * @Version 1.0
 **/
public class timu173 {

    
    Stack<TreeNode> stack ;

    /** 方法二
     * 使用栈模拟递归，参考思路：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
     * @param root
     */
    public timu173(TreeNode root) {
        stack = new Stack();
        addLeft(root);
    }

    public int next() {
        if (!stack.isEmpty()){
            TreeNode res = stack.pop();
            if (res.right!=null){
                addLeft(res.right);
            }
            return res.val;
        }
        return -1;
    }
    
    public void addLeft(TreeNode root){
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public boolean hasNext() {
        return stack.size()>0;
    }
    
}
