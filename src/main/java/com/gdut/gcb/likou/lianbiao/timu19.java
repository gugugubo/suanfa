package com.gdut.gcb.likou.lianbiao;



import com.gdut.gcb.niuke.lianbiao.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 古春波
 * @Description 19.删除链表的倒数第N个节点
 * @Date 2020/9/5 21:36
 * @Version 2.0
 **/
public class timu19 {

    /**
     * 一次遍历算法
     * 这题跟 牛客的timu22类似
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){return null;}
        ListNode node = head;
        while (node != null && n-->0){
            node = node.next;
        }
        
        if (n>0){
            return null;
        }
        if (node==null){
            return head.next;
        }
        
        ListNode listNode = head;
        ListNode preNode = head;
        while (node!= null){
            node = node.next;
            preNode = listNode;
            listNode = listNode.next;
        }

        preNode.next = listNode.next;
        return head;
        
    }

    public static void main(String[] args) {
        int[] ints = {1, 2};
        ListNode node = stringToIntegerArray(ints);

        ListNode node1 = removeNthFromEnd(node, 2);

    }

    public static ListNode stringToIntegerArray(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}

