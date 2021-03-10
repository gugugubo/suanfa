package com.gdut.gcb.niuke.lianbiao;

import java.util.ArrayList;

/**
 * @Author 古春波
 * @Description 55 链表中环的入口结点
 * @Date 2020/9/6 10:58
 * @Version 2.0
 **/
public class timu55 {
    /**
     * 使用哈希法迭代
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ArrayList<ListNode> nodes = new ArrayList<>();
        
        while (pHead!= null){
            if (nodes.contains(pHead) ){
                return pHead;
            }
            {
                nodes.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }


    /**
     * 使用快慢指针
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 注意这里不能直接使用while，不然会造成死循环
        do {
            if (slow==null||fast==null||fast.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        while (pHead != slow){
            pHead = pHead.next;
            slow = slow.next;
        }
        return pHead;
    }
    
}
