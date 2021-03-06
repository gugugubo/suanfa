package bobo.algo.likou.chazhaobiao;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @Date 2020/9/28 23:49
 * @Version 1.0
 * https://leetcode-cn.com/problems/two-sum/
 **/
public class timu1 {


    /**
     * 查找表。将所有元素放入查找表,之后对于每一个元素a,查找 target-a是否存在。
     * 但是不能先一次性将所有的元素放进查找表种，因为map结构可能会覆盖相同的值，
     * 如果target是82，它是由两个41组成，就会可能出问题。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> result = new HashMap<>();
        
        for (int i = 0 ;i < nums.length ; i ++){
            int toFindNum = target - nums[i];
            if (result.containsKey(toFindNum)){
                int[] ints = new int[2];
                ints[0] = i;
                ints[1] = result.get(toFindNum);
                return ints;
            }else {
                result.put(nums[i],i);
            }
        }
        return null;
    }



    

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        new timu1().twoSum(ints, 9);
    }
}
