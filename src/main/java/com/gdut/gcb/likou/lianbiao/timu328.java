package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;
import com.gdut.gcb.niuke.lianbiao.ListNode;

import java.util.ArrayList;

/**
 * @Author 古春波
 * @Description 328. 奇偶链表 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * @Date 2020/9/7 0:13
 * @Version 2.0
 **/
public class timu328 {
    public static ListNode oddEvenList(ListNode head) {
        
        if (head ==  null || head.next == null || head.next.next ==null){
            return head;
        }
        System.out.println();
        ListNode node = head;
        ListNode resNode = head;
        ListNode preNode = head;
        
        do {
            resNode = node;
            preNode = preNode.next;
            node = preNode.next;
            
            preNode.next = node.next;
            ListNode test = resNode.next;
            resNode.next = node;
            node.next = test;
        }
        while (preNode != null && preNode.next!= null && preNode.next.next!= null);
        
        return head;
    }

    /**
     * 迭代，进行链表拆分
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5};
        ListNode node = util.stringToIntegerArray(ints);
        oddEvenList(node);
    }
}
