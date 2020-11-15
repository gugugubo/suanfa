package com.gdut.gcb.niuke.lianbiao;

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
     * 递归的方法
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
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
