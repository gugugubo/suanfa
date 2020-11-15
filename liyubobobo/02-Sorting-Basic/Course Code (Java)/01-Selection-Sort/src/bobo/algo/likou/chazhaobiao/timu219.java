package bobo.algo.likou.chazhaobiao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/9/29 11:35
 * @Version 1.0
 **/
public class timu219 {


    /**
     * 这个的滑动窗口的大小是固定的, i 和 j 的差的 绝对值 至多为 k,说明窗口里面的元素最多可以有k+1个元素
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k <= 0){
            return false;
        }
        
        HashSet<Integer> hashSet = new HashSet<>(k);

        for (int i = 0; i< nums.length ;i++){
            if (hashSet.contains(nums[i])){
                return true;
            }
            
            if (hashSet.size() >= k){
                hashSet.remove(nums[i -k]);
            }
            
            hashSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,1,2,3};
        new timu219().containsNearbyDuplicate(ints,2);
    }
    
}
