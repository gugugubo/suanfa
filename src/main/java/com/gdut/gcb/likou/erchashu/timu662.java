package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;
import com.gdut.gcb.utils.util;

import java.util.*;

/**
 * @Author 古春波
 * @Description 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入: 
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \  
 *       5   3     9 
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/19 11:39
 * @Version 1.0
 **/
public class timu662 {


    /**https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/
     * 层序遍历，对比widthOfBinaryTree，避免复杂度指数级飙升，对比timu958
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        // 注意，这里是从0开始标号的
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                // 记录第一个非空节点，其实可以不用使用depth，而是将left初始化为-1，然后判断left是否为-1就行了
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    
    /**
     * 层序遍历，复杂度指数级上升，自己做的
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        //按层遍历即可
        //1.
        if (root == null) {
            return 0;
        }
        int maxRes  = 1;
        //2.
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int start = -1;int end=0;
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);
                if (remove!=null && start==-1){
                    start=i; 
                }
                if (remove!=null){
                    end = i;
                }
                TreeNode left =remove==null? null : remove.left ;
                nodes.add(left);
                TreeNode right =remove==null? null : remove.right ;
                nodes.add(right);
            }
            if (start==-1){
                return maxRes;
            }
            maxRes = Math.max( end-start+1, maxRes);
        }
        return maxRes;
    }


    /**
     *  链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/ceng-ci-bian-li-shi-xian-by-aaron_yu/
     * 使用一个LinkedList，而避免新建一个类
     * @param root
     * @return
     */
    public int widthOfBinaryTree3(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            for(int i =count; i> 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if(list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }

        return res;
    }
    

    public static void main(String[] args) {
        Object[] objects = new Object[]{
                0,0,0,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null
        };
        TreeNode treeNode1 = util.intToTreeNode(objects);
        String[] strings = new String[]{"1","3","2","5","3","null","9"};
        String[] strings2 = new String[]{"1","1","1","1","null","null","1","1","null","null","1"};
        TreeNode treeNode = util.stringToTreeNode(strings2);
        timu662 timu662 = new timu662();
        int i = timu662.widthOfBinaryTree(treeNode);
        System.out.println(i);
        int i2 = timu662.widthOfBinaryTree(treeNode1);
        System.out.println(i2);
    }
    
}
