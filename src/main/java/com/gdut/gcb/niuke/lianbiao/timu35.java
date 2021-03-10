package com.gdut.gcb.niuke.lianbiao;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author 古春波
 * @Description 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/2 19:58
 * @Version 1.0
 **/
public class timu35 {

    /**
     * 使用迭代的方式
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        //第一步，在每个节点的后面插入复制的节点。
        Node cur =  head;
        while(cur != null){
            Node cloneNode = new Node(cur.val);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        //第二步，对复制节点的 random 链接进行赋值。
        cur =  head;
        while (cur != null){
            Node cloneNode = cur.next;
            if (cur.random != null){
                // cur.random.next  cloneNode.random指向的新的节点，所以加了个next
                cloneNode.random = cur.random.next;
            }
            cur = cloneNode.next;
        }
        
        
        // 第三步，拆分。 
        cur =  head;

        Node clonePHead = new Node(-1);
        clonePHead.next = cur.next;
        while (cur.next != null){

            Node next = cur.next;
            
            cur.next = next.next;
            
            cur = next;
        }
        return clonePHead.next;
    }

    public Node copyRandomList2(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); //创建HashMap集合
        Node cur=head;
        //复制结点值
        while(cur!=null){
            //存储put:<key,value1>
            map.put(cur,new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur=cur.next;
        }
        //复制结点指向
        cur = head;
        while(cur!=null){
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }

        //返回复制的链表
        return map.get(head);

    }
    
    
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
