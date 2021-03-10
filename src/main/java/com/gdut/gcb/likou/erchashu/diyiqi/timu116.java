package com.gdut.gcb.likou.erchashu.diyiqi;

/**
 * @Author 古春波
 * @Description 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/3 23:48
 * @Version 1.0
 **/
public class timu116 {

    public Node2 connect(Node2 root) {
        if (root==null){
            return null;
        }
        recur(root.left , root.right);
        return root;
    }

    
    public void recur(Node2 left , Node2 right){
        if (left == null || right == null) {
            return;
        }

        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        left.next = right;

        // 连接相同父节点的两个子节点
        recur(left.left, left.right);
        recur(right.left, right.right);


        // 连接跨越父节点的两个子节点
        recur(left.right, right.left);
    }
    

    /**下面这个函数是不行的，6和3两个节点因为没有父节点，所以不能连接在一起
     *       4
     *     /   \
     *    7  -> 2
     *   / \   / \
     *  9 ->6 3 ->1
     * @param root
     * @return
     */
    Node2 connect2(Node2 root) {
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;

        connect2(root.left);
        connect2(root.right);

        return root;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
