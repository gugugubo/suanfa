package com.gdut.gcb.likou.mianshi.alibaba;

import com.gdut.gcb.niuke.erchashu.TreeNode;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/21 19:00
 * @Version 1.0
 **/
public class timu1 {


    public static void main(String[] args) {
        String s1 = new String("hello");
        String intern1 = s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String intern3 = s3.intern();
        String s4 = "hellohello";
        System.out.println(s3 == s4);
    }


    // 你打错了，不是sum是target，稳了，可以了
    // 可以了
    
    
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return target == root.val;
        }
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }
}


