package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/15 13:41
 * @Version 1.0
 **/
public class timu540 {


    /**
     * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
     * 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，
     * 此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {

        int left = 0 ; int right  = nums.length -1;

        while (left < right){

            int mid = left + (right - left) /2;
            
            // TODO 这里为什么不能mid++ ，mid++会死循环，为啥？
            if (mid % 2 == 1){
                mid --;
            }

            if (nums[mid + 1] == nums[mid]){
                // 这里left = mid+2不会使 left > right，因为mid比right小，right必定>= 单个元素的位置
                // left一定一直是偶数
                left = mid + 2;
            }else{
                // right此时一定是偶数
                right = mid;
            }

        }
        
       
        
        return nums[left];
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int i = new timu540().singleNonDuplicate(ints);
        System.out.println(i);
    }
    
//    public int firstBadVersion(int n) {
//        int left  = 1; int right = n;
//
//        if(left < right){
//            int mid = left + (right - left) /2;
//            
//            if (isBadVersion(mid)){
//                right = mid;
//            }else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
    
}
