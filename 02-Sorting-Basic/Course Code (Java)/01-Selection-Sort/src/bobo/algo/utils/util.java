package bobo.algo.utils;

import bobo.algo.niuke.lianbiao.ListNode;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2020/9/6 22:24
 * @Version 1.0
 **/
public  class  util {

    public static ListNode stringToIntegerArray(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
