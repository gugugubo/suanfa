package bobo.algo;

/**
 * 此节讲的二分搜索树都是不支持重复的元素的，如果是重复的元素则，认为是更新操作
 * @param <Key>
 * @param <Value>
 */

public class BST<Key extends Comparable<Key>, Value> {

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }


    public static void main(String[] args) {
    }
}