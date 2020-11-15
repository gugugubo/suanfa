package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 栈的压入、弹出序列
 * @Date 2020/9/14 22:15
 * @Version 1.0
 * 
 * url https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 **/
public class timu31 {

    Stack<Integer> stack1 ;
    
    // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]

    /**
     * 迭代法，使用一个辅助栈进行辅助模拟操作
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        stack1 = new Stack<>();
        
        int i=0;
        int j=0;
        while (j < popped.length){
            if(!stack1.isEmpty()  && stack1.peek() == popped[j]){
                j++;
                stack1.pop();
            }
            else {
                if (i< pushed.length){
                    stack1.push(pushed[i++]);
                }
                else {
                    break;
                }
            }
        }
        if (stack1.isEmpty() && i == pushed.length && j == popped.length){
            return true;
        }
        return false;
        
    }

    
    
    
    
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        new timu31().validateStackSequences(pushed,popped);
    }
    
}
