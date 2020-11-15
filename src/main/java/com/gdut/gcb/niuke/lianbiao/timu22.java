package com.gdut.gcb.niuke.lianbiao;

import java.util.List;

/**
 * @Author 古春波
 * @Description 链表中倒数第k个结点
 * @Date 2020/9/2 12:33
 * @Version 1.0
 **/
public class timu22 {

    /**
     * 迭代即可解决
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        while(node!= null&& k-- >0){
            node = node.next;
        }
        if (k>0){
            return null;
        }
        ListNode realNode = head;
        while (node != null){
            node = node.next;
            realNode = realNode.next;
        }
        return realNode;
    }
    
    
    
}
