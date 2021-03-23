package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description  反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/2 17:09
 * @Version 1.0
 **/
public class timu92 {

    /**
     * 迭代
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    /**
     * 反转前n个链表节点
     */
    static ListNode successor = null; // 后驱节点 
    static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null || n==1){
            successor = head.next;
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverseN(head.next, n-1);
        next.next = head;
        head.next = successor;
        return node;
    }


    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        ListNode node = util.stringToIntegerArray(ints);
        ListNode node1 = reverseN(node, 3);
        ListNode listNode = reverseBetween(node , 3,4);
    }
}
