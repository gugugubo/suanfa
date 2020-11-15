package com.gdut.gcb.niuke.lianbiao;

/**
 * @Author 古春波
 * @Description 节点类
 * @Date 2020/9/5 21:37
 * @Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}