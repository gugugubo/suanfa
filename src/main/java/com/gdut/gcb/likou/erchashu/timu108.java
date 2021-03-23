package com.gdut.gcb.likou.erchashu;

import com.gdut.gcb.niuke.erchashu.TreeNode;

/**
 * @Author 古春波
 * @Description  108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 9:17
 * @Version 1.0
 **/
public class timu108 {


    /**
     * 一下结论是需要证明的，属于贪心
     * 
     * 直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 111，可以使得树保持平衡。
     * 如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，
     * 则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点
     *
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0 , nums.length -1);
    }
    
    
    public TreeNode recur(int[] nums, int left , int right){
        if (left>right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode leftNode = recur(nums, left, mid-1);
        TreeNode rightNode = recur(nums, mid+1, right);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        timu108 timu108 = new timu108();
        
        int[] ints = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = timu108.sortedArrayToBST(ints);
        System.out.println(treeNode.val);

    }
}
