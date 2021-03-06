package bobo.algo.likou.lianbiao;

import bobo.algo.niuke.lianbiao.ListNode;

/**
 * @Author 古春波
 * @Description 24. 两两交换链表中的节点
 * @Date 2020/9/6 20:31
 * @Version 1.0
 **/
public class timu24 {


    /**
     * 通过递归，第一次自己写的递归，hhh，nb
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null){
            return head ;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        
        // 初始化
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 交换节点
        preNode.next = secondNode;
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;

        ListNode node = swapPairs2(firstNode.next);
        firstNode.next = node;
        
        return dummy.next;
    }
    
    

    /**
     * 使用迭代的方法 
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head ;
        }
        //给定 1->2->3->4, 你应该返回 2->1->4->3.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        while (head!= null && head.next!= null){
            
            // 初始化
            ListNode firstNode = head;
            ListNode secondNode = head.next;
                
            // 交换节点
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            preNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

}
