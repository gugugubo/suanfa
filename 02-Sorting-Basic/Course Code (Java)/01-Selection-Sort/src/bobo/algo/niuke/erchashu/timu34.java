package bobo.algo.niuke.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @Date 2020/9/11 17:26
 * @Version 1.0
 * url: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 **/
public class timu34 {

    /**
     * 所有的可能路径
     */
    List<List<Integer>> result = new LinkedList<>();
    /**
     * 某一个路径
     */
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 使用递归实现，dfs先序遍历
     * 时间复杂度 O(N) ：N为二叉树的节点数，先序遍历需要遍历所有节点。
     * 空间复杂度 O(N) ：最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N)额外空间。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        subTest(root,sum);
        return result;
    }

    public void subTest(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        path.add(root.val);
        sum = sum - root.val;
        if ( 0 == sum && root.left== null && root.right== null){
            result.add(new ArrayList<>(path));
        }

       
        subTest(root.left,sum);
        subTest(root.right,sum);
        path.removeLast();
    }
    
}
