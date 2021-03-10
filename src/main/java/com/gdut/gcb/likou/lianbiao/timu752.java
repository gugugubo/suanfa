package com.gdut.gcb.likou.lianbiao;


import com.gdut.gcb.niuke.lianbiao.ListNode;
import com.gdut.gcb.utils.util;

/**
 * @Author 古春波
 * @Description 把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。
 * @Date 2020/9/7 17:28
 * @Version 1.0
 **/
public class timu752 {


    /**
     * 使用迭代法 创建新列表
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode[] result = new ListNode[k];
        ListNode cur = root;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        
        // 需要多加的元素
        int moreNum =  length%k;  

        // 每个节点能存的元素
        int everyNode = length/k;
        
        cur = root;
        
        for (int i = 0; i<k;i++){
            ListNode head = new ListNode(-1);
            ListNode newNode = head;
  
            for (int j = 0; j < everyNode + ( i < moreNum? 1: 0) && cur!=null ;j++ ){
                ListNode node1 = new ListNode(cur.val);
                newNode = newNode.next = node1;
                cur = cur.next;
            }
            result[i] = head.next;
        }
        return result;
        
    }


    /**
     * 比上面那个稍微改进一下
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts2(ListNode root, int k) {


        int length = 0;
        ListNode[] result = new ListNode[k];
        ListNode cur = root;
        while (cur != null){
            length++;
            cur = cur.next;
        }

        // 需要多加的元素
        int moreNum ;

        // 每个节点能存的元素
        int everyNode ;
        if (length/k == 0){
            everyNode = 1;
            moreNum = 0;
        }else {
            everyNode = length/k;
            moreNum = length%k;
        }

        cur = root;
        for (int i = 0; i<k;i++){
            ListNode head = new ListNode(-1);
            ListNode newNode = head;
            if (moreNum != 0){
                moreNum --;
                for (int j = everyNode +1; cur!=null && j>0;j-- ){
                    ListNode node1 = new ListNode(cur.val);
                    newNode.next = node1;
                    newNode = node1;
                    cur = cur.next;
                }
                result[i] = head.next;
            }else {
                for (int j = everyNode; cur!=null && j>0;j-- ){
                    ListNode node1 = new ListNode(cur.val);
                    newNode.next = node1;
                    newNode = node1;
                    cur = cur.next;
                }
                result[i] = head.next;
            }
        }
        return result;

    }





    public static void main(String[] args) {
        int[] ints = {1,2,3,4};
        ListNode node = util.stringToIntegerArray(ints);
        splitListToParts(node,5);
    }
}
