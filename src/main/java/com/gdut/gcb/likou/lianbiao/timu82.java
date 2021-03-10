package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 23:10
 * @Version 1.0
 **/
public class timu82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null){
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = head, pre = root;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                // 注意空指针
                while (cur != null && cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                // 因为重复的被清除了，所以pre不用更新
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }

    ListNode pre ;
    public  ListNode deleteDuplicates2(ListNode head) {
        ListNode root= new ListNode(-1);
        this.pre = root;
        root.next = head;
        recur(root);
        return root.next;
    }
    

    public ListNode recur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = recur(head.next);
        if (head != null && head.next != null && head.next.val == head.val) {
            // while循环记得再次检验非空
            while (head != null && head.next != null && head.next.val == head.val) {
                // pre 是为了处理出现3次及3次以上重复元素的情况
                this.pre = head;
                head = head.next;
            }
            return head.next;
        } else if (head.val == pre.val) {
            // while循环记得再次检验非空
            while (head != null && head.val == pre.val) {
                this.pre = head;
                head = head.next;
            }
        } 
         return head;
//        return head.val == head.next.val ? head.next  : head;

    }
    public static void main(String[] args) {
        timu82 timu82 = new timu82();
        int[] ints = new int[]{1,1};
        ListNode node = util.stringToIntegerArray(ints);
        ListNode node1 = timu82.deleteDuplicates(node);
        ListNode node2 = timu82.deleteDuplicates2(node);
        System.out.println(node1.val);
        System.out.println(node2.val);
    }
}
