package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/17 16:11
 * @Version 1.0
 **/
public class timu42 {


    public int trap1(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;
            // 找右边最高的柱子
            for (int j = i; j < n; j++){
                r_max = Math.max(r_max, height[j]);
            }
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--){
                l_max = Math.max(l_max, height[j]);
            }
            // 如果自己就是最高的话，
            // l_max == r_max == height[i]
            res += Math.max(l_max, r_max) - height[i];
        }
        return res;
    }


    /**
     * 使用备忘录进行优化，dp
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int length = height.length;
        if (length==0){
            return 0;
        }
        int[] leftDp = new int[length];
        int[] rightDp = new int[length];
        leftDp[0] = height[0];
        rightDp[length-1] = height[length-1];
        
        // dp
        for (int i=1; i<length; i++){
            leftDp[i] = Math.max(leftDp[i-1], height[i]);
        }
        for (int i=length-2; i>=0;i--){
            rightDp[i] = Math.max(rightDp[i+1], height[i]);
        }
        int res = 0;
        for (int i=1;i<length-1;i++){
            res += Math.min(leftDp[i] , rightDp[i]) - height[i];
        }
        return res;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int length = height.length;
        if (length==0){
            return 0;
        }
        int i=0; int j = length-1;
        int leftMax = height[0]; int rightMax = height[length-1];
        int res = 0;
        while (i<=j){
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[j], rightMax);
            if (leftMax<rightMax){
                res += leftMax - height[i];
                i++;
            }else {
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
