package bobo.algo.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明：
 *
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/13 23:59
 * @Version 1.0
 **/
public class timu88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1 ;  int j = n -1;
        
        int index = m + n -1;
        while (i >=0 || j >= 0){
            if (i >=0 && j >= 0 && nums1[i] > nums2[j]){
                nums1[index--] = nums1[i--];
            }else if (i >=0 && j >= 0 && nums1[i] < nums2[j]){
                nums1[index--] = nums2[j--];
            }else if (i>= 0){
                nums1[index--] = nums1[i--];
            }else {
                nums1[index--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        
        new timu88().merge(nums1, 3, nums2, 3);
        
    }
    
    
}
