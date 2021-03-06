package bobo.algo.niuke.lianbiao;

/**
 * @Author 古春波
 * @Description 52. 两个链表的第一个公共节点
 * @Date 2020/9/4 9:30
 * @Version 1.0
 **/
public class timu52 {


    /**
     * 迭代解决问题
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode node1 = headA;
        
        ListNode node2 = headB;
        
        while(node1 != node2){
            node1 = node1 == null? headB : node1.next;
            node2 = node2 == null? headA : node2.next;
        }
        return node1;
    }
}
