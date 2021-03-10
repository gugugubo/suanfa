package com.gdut.gcb.likou.lianbiao;

import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/6 21:02
 * @Version 1.0
 **/
public class timu86 {

    /**
     * 我的思路：直接遍历，双指针
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode node = head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode left = node;
        
        ListNode maxPre = root;
        while (node!=null){
            if (node.val>=x){
                break;
            }
            maxPre=node;
            node = node.next;
        }
        ListNode thisPre = maxPre;
        while (node!=null){
            if (node.val>=x){
                thisPre = node;
                node=node.next;
            }else {
                ListNode nextNode = node.next;
                thisPre.next = nextNode;
                ListNode next = maxPre.next;
                maxPre.next=node;
                node.next = next;
                maxPre = node;
                node = nextNode;
            }
        }
        return root.next;
    }

    /**
     * 分成两个链表更好理解：
     *     链接：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode-solution-7ade/
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
    
    
    

    public static void main(String[] args) {
        int[] ints = new int[]{1,4,3,2,5,2};
        ListNode node = util.stringToIntegerArray(ints);
        timu86 timu86 = new timu86();
        ListNode partition = timu86.partition(node, 3);
        System.out.println(partition);
    }
    
}
