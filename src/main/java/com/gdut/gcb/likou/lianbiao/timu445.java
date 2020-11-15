package com.gdut.gcb.likou.lianbiao;

import bobo.algo.niuke.lianbiao.ListNode;

import java.util.Stack;

import static bobo.algo.utils.util.stringToIntegerArray;

/**
 * @Author 古春波
 * @Description 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * @Date 2020/9/6 21:59
 * @Version 1.0
 **/
public class timu445 {


    /**
     * 迭代，使用三个栈  自己写的
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        while (l1!= null){
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2!= null){
            l2Stack.add(l2.val);
            l2 = l2.next;
        }
        
        int push =0;
        while(!l1Stack.isEmpty() && !l2Stack.isEmpty()){
            Integer pop1 = l1Stack.pop();
            Integer pop2 = l2Stack.pop();
            result.add((pop1 +pop2 + push) % 10);
            if (pop1 + pop2 + push >=10){
                push = 1;
            }else {
                push = 0;
            }
        }
        

        
        while (!l1Stack.isEmpty()){
            Integer pop1 = l1Stack.pop();
            result.add((pop1 + push) % 10);
            if (pop1 + push >=10){
                push = 1;
            }else {
                push = 0;
            }
        }   
        
        while (!l2Stack.isEmpty()){
            Integer pop2 = l2Stack.pop();
            result.add((pop2 + push) % 10);
            if (pop2 + push >=10){
                push = 1;
            }else {
                push = 0;
            }
        }
        if (l1Stack.isEmpty() && l2Stack.isEmpty() && push ==1 ){
            result.add(1);
        }

        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (!result.isEmpty()){
            node.next = new ListNode(result.pop());
            node = node.next;
        }
        return head.next;
    }


    /**
     * 迭代，使用两个栈和头插法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1!= null){
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2!= null){
            l2Stack.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry > 0){
            int sum = carry;
            sum += l1Stack.isEmpty()? 0 : l1Stack.pop();
            sum += l2Stack.isEmpty()? 0 : l2Stack.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
    

        public static void main(String[] args) {
        int[] ints1= {9,9};
        int[] ints2= new int[]{1};
        
        ListNode l1 = stringToIntegerArray(ints1);
        ListNode l2 = stringToIntegerArray(ints2);

        addTwoNumbers(l1,l2);
    }
}
