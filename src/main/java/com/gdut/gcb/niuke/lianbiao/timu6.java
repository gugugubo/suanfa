package com.gdut.gcb.niuke.lianbiao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 从尾到头打印链表
 * @Date 2020/9/2 10:01
 * @Version 1.0
 **/
public class timu6 {

    /**
     * 解法1，使用栈结构
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        while(listNode != null){
            stack.add(listNode.val); 
            listNode = listNode.next;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        while (!stack.isEmpty()){
            objects.add(stack.pop());
        }
        return objects;
    }

    /**
     * 使用递归翻转链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> objects = new ArrayList<>();
        if (listNode!=null){
            objects.addAll(printListFromTailToHead2(listNode.next));
            objects.add(listNode.val);
        }
        return objects;
    }

    // 从尾到头打印链表
    private void printListFromTailToHead4(ListNode listNode) {
        if (listNode == null){
            return;
        }
        printListFromTailToHead4(listNode.next);
        System.out.println(listNode.val);
    }

    /**
     * 迭代：使用头插入法构建新的链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
            ListNode head = new ListNode(-1);
            
            while (listNode != null){
                ListNode next = listNode.next;
                listNode.next = head.next;
                head.next = listNode;
                listNode = next;
            }
            ArrayList<Integer> integers = new ArrayList<>();
            ListNode node = head.next;
            while (node!= null){
                integers.add(node.val);
                node = node.next;
            }
            return integers;
    }
    
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode2;
        ArrayList<Integer> integers = new timu6().printListFromTailToHead(listNode);
        System.out.println(integers);    
        ArrayList<Integer> integers2 = new timu6().printListFromTailToHead2(listNode);
        System.out.println(integers2);       
        ArrayList<Integer> integers3 = new timu6().printListFromTailToHead3(listNode);
        System.out.println(integers3);
    }
    
  
     
}
