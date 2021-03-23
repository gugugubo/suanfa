package bobo.algo.likou.shaungzhizhen.yuandixiugai;

/**
 * @Author 古春波
 * @Description 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2], 
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/9 9:33
 * @Version 1.0
 **/
public class timu26 {

    // 使用快慢指针
    public int removeDuplicates(int[] nums) {
        int i=0 , j=0;
        int first;
        int length = nums.length;
        if (length==0){
            return 0;
        }
        while (j<length){
            first = nums[j];
            nums[i++] = first;
            while (j<length && nums[j]==first){
                j++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        timu26 timu26 = new timu26();
        int[] ints = new int[]{1,1,2};
        int i = timu26.removeDuplicates(ints);
        System.out.println(i);
    }
}
