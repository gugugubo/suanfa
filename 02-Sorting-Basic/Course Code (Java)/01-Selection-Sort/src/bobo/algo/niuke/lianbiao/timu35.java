package bobo.algo.niuke.lianbiao;

import java.util.Random;

/**
 * @Author 古春波
 * @Description 复杂链表的复制
 * @Date 2020/9/2 19:58
 * @Version 1.0
 **/
public class timu35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return pHead;
        }
        //第一步，在每个节点的后面插入复制的节点。
        RandomListNode cur =  pHead;
        while(cur != null){
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        //第二步，对复制节点的 random 链接进行赋值。
        cur =  pHead;
        while (cur != null){
            RandomListNode cloneNode = cur.next;
            if (cur.random != null){
                cloneNode.random = cur.random.next;
            }
            cur = cloneNode.next;
        }
        
        
        // 第三步，拆分。 
        cur =  pHead;

        RandomListNode clonePHead = new RandomListNode(-1);
        clonePHead.next = cur.next;
        while (cur.next != null){
            
            RandomListNode next = cur.next;
            
            cur.next = next.next;
            
            cur = next;
        }
        return clonePHead.next;
        
    }
    
    
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
