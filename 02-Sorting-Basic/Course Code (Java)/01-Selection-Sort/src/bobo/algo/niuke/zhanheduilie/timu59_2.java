package bobo.algo.niuke.zhanheduilie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 **/
public class timu59_2 {

    Queue<Integer> queue = new LinkedList();

    LinkedList<Integer> maxQueue = new LinkedList();

    public timu59_2() {
        
    }

    public int max_value() {
        if (maxQueue.isEmpty()){
            return  -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (maxQueue.isEmpty()){
            return  -1;
        }
        if (maxQueue.peekFirst().equals(queue.peek())){
            maxQueue.removeFirst();
        }
        return  queue.poll();
    }

    public static void main(String[] args) {
        timu59_2 test = new timu59_2();
        test.max_value();
        test.push_back(1);
        test.push_back(2);
        test.max_value();
        test.pop_front();
        test.max_value();
    }
}
