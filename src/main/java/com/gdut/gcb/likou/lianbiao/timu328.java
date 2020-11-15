package com.gdut.gcb.likou.lianbiao;

import bobo.algo.niuke.lianbiao.ListNode;
import bobo.algo.utils.util;

/**
 * @Author 古春波
 * @Description 328. 奇偶链表 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * @Date 2020/9/7 0:13
 * @Version 1.0
 **/
public class timu328 {
    public static ListNode oddEvenList(ListNode head) {
        
        if (head ==  null || head.next == null || head.next.next ==null){
            return head;
        }
        
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

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5};
        ListNode node = util.stringToIntegerArray(ints);
        oddEvenList(node);
    }
}
