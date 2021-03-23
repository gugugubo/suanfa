package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;

/**
 * @Author 古春波
 * @Description 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/2 20:33
 * @Version 1.0
 **/
public class timu234 {
    
    //方法一：将值复制到数组中后用双指针法
    
    
    
//    方法二：递归
//    我们知道，如果对链表逆序打印可以这样写
//    private void printListNode(ListNode head) {
//        if (head == null)
//            return;
//        printListNode(head.next);
//        System.out.println(head.val);
//    }
//
//    也就是说最先打印的是链表的尾结点，他是从后往前打印的，如果以后谁再给你说单向链表不能从后往前遍历，
//    你就拿这段代码怼他，哈哈。看到这里是不是有灵感了，我们来对上面的对面进行改造一下

    ListNode left;
    public boolean isPalindrome(ListNode head) {
        this.left = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        // 一直进入这个递归到末尾，head为最后一个节点了
        if (check(head.next) && head.val == left.val){
            left = left.next;
            return true;
        }
        return false;
    }

    
    // 方法三：我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较
    
    
}
