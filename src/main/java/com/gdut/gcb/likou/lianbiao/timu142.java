package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;

/**
 * @Author 古春波
 * @Description 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 *     你是否可以使用 O(1) 空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/10 15:43
 * @Version 1.0
 **/
public class timu142 {

    /**
     * 自己做的
     * @param pHead
     * @return
     */
    public ListNode detectCycle(ListNode pHead) {
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

    /**
     * 答案，跟上面自己做的一样，不过代码可读性更强
     *     链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     *     
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }


    // 可以使用set做
    public ListNode detectCycle3(ListNode head) {
        return null;
    }
}
