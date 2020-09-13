package bobo.algo.niuke.erchashu;

/**
 * @Author 古春波
 * @Description 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * @Date 2020/9/11 23:08
 * @Version 1.0
 * url https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 **/
public class timu26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return   (A != null && B != null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    boolean recur(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
    
}
