package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/17 21:39
 * @Version 1.0
 **/
public class timu2 {

    /**
     * 参考timu445实现的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> l1Stack = new LinkedList<>();
        Queue<Integer> l2Stack = new LinkedList<>();

        while (l1!= null){
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2!= null){
            l2Stack.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head =  new ListNode(-1), pre = head;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry > 0){
            int sum = carry;
            sum += l1Stack.isEmpty()? 0 : l1Stack.remove();
            sum += l2Stack.isEmpty()? 0 : l2Stack.remove();
            ListNode node = new ListNode(sum % 10);
            pre.next = node;
            pre = node;
            carry = sum / 10;
        }
        return head.next;
    }

    /**
     * 参考上面的解法，但是去掉了栈的使用
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head =  new ListNode(-1), pre = head;
        while (l1!=null || l2!=null || carry > 0){
            int sum = carry;
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            pre.next = node;
            pre = node;
            carry = sum / 10;
        }
        return head.next;
    }
}
