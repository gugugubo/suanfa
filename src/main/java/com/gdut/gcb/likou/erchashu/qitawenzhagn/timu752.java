package com.gdut.gcb.likou.erchashu.qitawenzhagn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author 古春波
 * @Description 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 11:49
 * @Version 1.0
 **/
public class timu752 {

    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String dead : deadends){
            deads.add(dead);
        }
        int step=0;
        // 记录已经穷举过的密码，防止走回头路
        HashSet<Object> visited = new HashSet<>();

        Queue<String> queue = new LinkedList();
        queue.add("0000");
        visited.add("0000");
        
        while (!queue.isEmpty()){
            int sz = queue.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int j = 0; j < sz; j++) {
                String remove = queue.remove();
                visited.add(remove);
                if (remove.equals(target)){
                    return step;
                }

                for (int i=0 ; i<4; i++){

                    String s = plusOne(remove, i);
                    if (!visited.contains(s) && !deads.contains(s)){
                        queue.add(s);
                    }
                    String s1 = minusOne(remove, i);
                    if (!visited.contains(s1) && !deads.contains(s1)){
                        queue.add(s1);
                    }
                }
            }
            step++;
        }
        return -1;
    }

   

    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
    
    
}
