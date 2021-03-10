package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/7 16:37
 * @Version 1.0
 **/
public class timu61 {


    /**
     * 对比timu189
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        int count  = 0; 
        ListNode node = head;
        while (node!= null){
            count++;
            node = node.next;
        }
        if (count<2 || k<=0){
            return head;
        }
        k = k % count;
        if (k<=0){
            return head;
        }
        node = head;
        for (int i=0 ; i<count - k -1; i++){
            node = node.next;
        }
        ListNode next = node.next;
        ListNode newHead = next;
        node.next = null;
        node = next;
        while (node.next!=null){
            node=node.next;
        }
        node.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        timu61 timu61 = new timu61();
        int[] ints = new int[]{1,2,3,4,5};
        ListNode node = util.stringToIntegerArray(ints);
        ListNode node1 = timu61.rotateRight(node, 2);
        System.out.println(node1.val);
    }
    
}
