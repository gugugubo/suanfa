package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 20:01
 * @Version 1.0
 **/
public class timu148 {


    /**https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
     * 归并排序，可以参考timu23合并k个有序链表的归并排序
     * 
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        // 这个tail是取不到的
        if (head.next == null) {
            return head;
        }
        // 找到中间节点的前一个节点
        ListNode midPre = middleNode(head);
        // 分割成两个链表
        if (midPre!=null){
            ListNode next = midPre.next;
            midPre.next = null;
            midPre = next;
        }
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(midPre);
        ListNode node1 = mergeTwoLists(l1, l2);
        return node1;
    }

    /** 
     * 这里返回的是中间节点的前一个，如果不是这样，而是返回的slow指针指向的节点，那么可能head指向的链表只有两个节点的时候，会造成死循环
     * 寻找链表的中间节点timu876
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast, slow, pre;
        pre = fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // slow 就在中间位置
        return pre;
    }

    /**
     * 合并两个有序链表，timu25
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {return l1;}
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] strings = new int[]{4,2,1,3};
        ListNode treeNode = util.stringToIntegerArray(strings);
        timu148 timu148 = new timu148();
        timu148.sortList(treeNode);

    }
}
