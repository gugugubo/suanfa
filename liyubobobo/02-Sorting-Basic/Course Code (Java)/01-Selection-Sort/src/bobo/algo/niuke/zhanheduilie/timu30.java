package bobo.algo.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 30. 包含min函数的栈 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @Date 2020/9/14 20:47
 * @Version 1.0
 * url https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 **/
public class timu30 {

    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;

    /**
     * 使用辅助栈实现
     * 时间复杂度 O(1) ： push(), pop(), top(), min() 四个函数的时间复杂度均为常数级别。
     * 空间复杂度 O(N) ： 当共有 N 个待入栈元素时，辅助栈 B 最差情况下存储 N 个元素，使用 O(N) 额外空间。
     *
     */
    public timu30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    
    public void push(int x) {
        if (stack2.isEmpty() || !stack2.isEmpty() &&x < stack2.peek()){
            stack2.push(x);
        }else {
            stack2.push(stack2.peek());
        }
        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        timu30 minStack = new timu30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();  
        minStack.pop();
        minStack.top();  
        minStack.min();  
    }
}
