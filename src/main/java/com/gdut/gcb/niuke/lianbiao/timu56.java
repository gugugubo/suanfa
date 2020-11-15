package com.gdut.gcb.niuke.lianbiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 古春波
 * @Description 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Date 2020/9/5 15:50
 * @Version 1.0
 **/
public class timu56 {

    /**
     * 递归的方法
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicates(head.next);
        
        return head.val == head.next.val ? head.next  : head;
    }

    /**
     * 使用迭代的方法
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head ==null){
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
    
    

    public static void main(String[] args) {
        int[] ints = {
                1,2,10,4,1,4,3,3
        };
//        deleteDuplicates(ints);
    }
    
}

