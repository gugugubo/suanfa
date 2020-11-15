package com.gdut.gcb.niuke.lianbiao;

/**
 * @Author 古春波
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Date 2020/9/2 15:47
 * @Version 1.0
 **/
public class timu25 {

    /**
     * 递归的方式
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        
        if (list2 == null){
            return list1;
        }
        
        if (list1.val < list2.val){
            ListNode merge = Merge(list1.next, list2);
            list1.next = merge;
            return list1;
        }
        else {
            ListNode merge = Merge(list2.next, list1);
            list2.next = merge;
            return list2;
        }
    }


    /**
     * 迭代法解决
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        
        
        while (list1!= null && list2 != null){
            if (list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        
        if (list1 != null){
            node.next = list1;
        }
        
        if (list2!= null){
            node.next = list2;
        }
        return head.next;
        
    }
}
