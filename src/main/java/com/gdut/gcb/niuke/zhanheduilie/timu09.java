package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/14 20:24
 * @Version 1.0
 **/
public class timu09 {
    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;

    /**
     * 观察示例操作可以得出结论
     * 时间复杂度： appendTail()函数为 O(1)；deleteHead() 函数在 N 次队首元素删除操作中总共需完成 N 个元素的倒序。
     * 空间复杂度 O(N) ： 最差情况下，栈 A 和 B 共保存 N 个元素。
     *
     */
    public timu09() {
         stack1 = new Stack<>();
         stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.add(pop);
            }
            if (stack2.isEmpty()){
                return -1;
            }else {
                return stack2.pop();
            }
        }
        
    }

    public static void main(String[] args) {
        timu09 test = new timu09();
        test.appendTail(0);
        test.appendTail(0);
        test.appendTail(3);
        test.appendTail(-1);
        test.deleteHead();
        test.deleteHead();
        test.deleteHead();
    }
    
}
