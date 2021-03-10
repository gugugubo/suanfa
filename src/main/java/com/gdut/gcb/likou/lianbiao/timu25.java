package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 25. K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/2 19:40
 * @Version 1.0
 **/
public class timu25 {


    /**
     * 反转head开始的K个解点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start, end, node = head;
        start = head;
        for (int i=0; i < k; i++){
            // 处理base case
            if (node==null){
                return head;
            }
            node = node.next;
        }
        end = node;
        ListNode reverse = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return reverse;
    }

    /**
     * 反转start与end之间的链表，左闭右开
     * @return
     */
    public ListNode reverse(ListNode start , ListNode end){
        ListNode head = new ListNode(-1);
        ListNode next , node=start;
        while (node!=end){
            next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        ListNode node = util.stringToIntegerArray(ints);
        timu25 timu25 = new timu25();
        ListNode node1 = timu25.reverseKGroup(node, 2);
        System.out.println(node1);
        
        
    }
}
