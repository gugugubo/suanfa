package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 18:03
 * @Version 1.0
 **/
public class timu143 {


    /**
     * 自己想的，利用栈
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null){
            return;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head, node1=head;
        int count = 0;
        while (node!=null){
            stack.add(node);
            node = node.next;
            count++;
        }
        
        for (int i=0; i<count/2; i++){
            ListNode pop = stack.pop();
            pop.next = node1.next ;
            node1.next = pop;
            node1 = pop.next;
        }
        
        
        if (count%2!=1){
            node1.next = null;
        }else {
            node1.next = stack.pop();
            node1.next.next = null;
        }
    }
    
    
    public ListNode recur(ListNode head){
      return null;
        
    }
}
