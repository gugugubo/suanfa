package com.gdut.gcb.niuke.lianbiao;

import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 反转链表
 * @Date 2020/9/2 13:02
 * @Version 1.0
 **/
public class timu24 {

    /**
     * 迭代:使用头插入法构建新的链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        ListNode list = new ListNode(-1);

        while (head != null){
            ListNode next = head.next;
            head.next = list.next;
            list.next = head;
            head = next;
        }
        
        return list.next;
    }

    /**
     * 迭代:使用头插入法但是不使用头结点
     * @param head
     * @return
     */
    public ListNode ReverseList3(ListNode head) {

        ListNode list = null;

        while (head != null){
            ListNode next = head.next;
            head.next = list;
            list = head;
            head = next;
        }

        return list;
    }
    
    /**
     * 递归的方法，ReverseList2()返回的是head链表的反转之后的链表
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode node = ReverseList2(next);
        next.next = head;
        return node;
    }



  
}
