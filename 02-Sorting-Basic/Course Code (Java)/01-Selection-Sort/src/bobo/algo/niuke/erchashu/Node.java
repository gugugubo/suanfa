package bobo.algo.niuke.erchashu;

/**
 * @Author 古春波
 * @Description 二叉树节点
 * @Date 2020/9/11 19:18
 * @Version 1.0
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}